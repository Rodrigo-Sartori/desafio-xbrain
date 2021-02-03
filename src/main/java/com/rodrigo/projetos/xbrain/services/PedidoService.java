package com.rodrigo.projetos.xbrain.services;

import com.rodrigo.projetos.xbrain.controllers.domain.PedidoDTO;
import com.rodrigo.projetos.xbrain.execption.DefaultExeption;
import com.rodrigo.projetos.xbrain.repositories.ClienteRepository;
import com.rodrigo.projetos.xbrain.repositories.PedidoRepository;
import com.rodrigo.projetos.xbrain.repositories.ProdutoRepository;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import com.rodrigo.projetos.xbrain.repositories.domain.Pedido;
import com.rodrigo.projetos.xbrain.repositories.domain.Produto;
import com.rodrigo.projetos.xbrain.utils.ConverterDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {


    private PedidoRepository pedidoRep;

    private RabbitTemplate rabbitTemplate;

    private ClienteRepository clienteRep;

    private ProdutoRepository produtoRep;

    @Value("${app.queue.name}")
    public String queueName;

    @Autowired
    public PedidoService(PedidoRepository pedidoRep, RabbitTemplate rabbitTemplate, ClienteRepository clienteRep,
                         ProdutoRepository produtoRep) {
        this.pedidoRep = pedidoRep;
        this.rabbitTemplate = rabbitTemplate;
        this.clienteRep = clienteRep;
        this.produtoRep = produtoRep;
    }

    public Pedido enviar(PedidoDTO dto) throws DefaultExeption {
        Pedido pedido = ConverterDTO.converterPedidoDto(dto);
        try {
            pedido = pedidoRep.save(pedido);
            validar(pedido);
            rabbitTemplate.convertAndSend(queueName, pedido);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DefaultExeption("ocorreu um erro ao salvar o pedido no banco: " + e.getClass());
        }
        return pedido;
    }

    private void validar(Pedido pedido) throws DefaultExeption {
        BigDecimal valorTotalSomado = new BigDecimal(BigInteger.ZERO);
        Optional<Cliente> clienteOp = clienteRep.findByCodigo(pedido.getCodigoCliente());
        if (clienteOp.isEmpty()) throw new DefaultExeption("cliente não listado na base de dados");
        List<Produto> produtos = produtoRep.findAll();
        for (Integer codigo : pedido.getCodigoProduto()) {
            List<Produto> produtosDoPedido = produtos.stream().filter(p -> p.getCodigo().equals(codigo)).
                    collect(Collectors.toList());
            if (produtosDoPedido.isEmpty())
                throw new DefaultExeption("produto com código " + codigo + " não está registrado na base de dados");
            valorTotalSomado = valorTotalSomado.add(produtosDoPedido.get(0).getValor());
        }
        if (pedido.getValorTotal().compareTo(valorTotalSomado) != 0) throw new DefaultExeption("valor total está incorreto");


    }
}
