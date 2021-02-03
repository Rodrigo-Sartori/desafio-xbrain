package com.rodrigo.projetos.xbrain.listener;

import com.rodrigo.projetos.xbrain.controllers.domain.PedidoDTO;
import com.rodrigo.projetos.xbrain.execption.DefaultExeption;
import com.rodrigo.projetos.xbrain.repositories.EntregaRepository;
import com.rodrigo.projetos.xbrain.repositories.domain.Entrega;
import com.rodrigo.projetos.xbrain.repositories.domain.Pedido;
import com.rodrigo.projetos.xbrain.services.PedidoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName(value = "teste de repositório da entidade produto")
public class RecebedorTeste {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private EntregaRepository rep;

    @Value("${app.queue.name}")
    public String queueName;

    private Pedido pedidoTeste;

    public void criarPedido() {
        pedidoTeste = new Pedido();
        pedidoTeste.setCodigoCliente(4321);
        List<Integer> lista = new ArrayList<>();
        lista.add(1234);
        lista.add(1234);
        pedidoTeste.setCodigoProduto(lista);
        pedidoTeste.setValorTotal(new BigDecimal("20.50"));
        pedidoTeste.setEnderecoEntrega("endereço de teste número 12345");
    }

    @BeforeEach
    public void preparador() {
        criarPedido();
    }

    @Test
    @DisplayName(value = "Deve enviar pedido para fila com sucesso")
    public void deveInserirPedidoComSucesso() {
        try {
            rabbitTemplate.convertAndSend(queueName, pedidoTeste);
            List<Entrega> entregas = rep.findAll();
            Assertions.assertFalse(entregas.isEmpty());
            System.out.println(entregas.toString());
        } catch (Exception e) {
            Assertions.fail("deveria ter inserido com sucesso:" + e.getMessage());
        }
    }


}
