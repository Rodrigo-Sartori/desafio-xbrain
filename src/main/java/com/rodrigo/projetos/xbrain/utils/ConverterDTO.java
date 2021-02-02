package com.rodrigo.projetos.xbrain.utils;

import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import com.rodrigo.projetos.xbrain.controllers.domain.PedidoDTO;
import com.rodrigo.projetos.xbrain.controllers.domain.ProdutoDTO;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import com.rodrigo.projetos.xbrain.repositories.domain.Pedido;
import com.rodrigo.projetos.xbrain.repositories.domain.Produto;

import java.util.ArrayList;
import java.util.List;

public class ConverterDTO {


    public static Cliente converterClienteDto(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCodigo(Integer.parseInt(dto.getCodigo()));
        return cliente;
    }

    public static ClienteDTO converterCliente(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setNome(cliente.getNome());
        dto.setCodigo(cliente.getCodigo().toString());
        dto.setId(String.valueOf(cliente.getId()));
        return dto;
    }

    public static Produto converterProdutoDto(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setCodigo(Integer.parseInt(dto.getCodigo()));
        produto.setValor(dto.getValor());
        return produto;
    }

    public static ProdutoDTO converterProduto(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setNome(produto.getNome());
        dto.setCodigo(produto.getCodigo().toString());
        dto.setValor(produto.getValor());
        dto.setId(String.valueOf(produto.getId()));
        return dto;
    }

    public static Pedido converterPedidoDto(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        List<Integer> listaCodigo = new ArrayList<>();
        pedido.setCodigoCliente(Integer.parseInt(dto.getCodigoCliente()));
        for (String cod: dto.getCodigoProduto()) {
            listaCodigo.add(Integer.parseInt(cod));
        }
        pedido.setCodigoProduto(listaCodigo);
        pedido.setValorTotal(dto.getValorTotal());
        return pedido;
    }

    public static PedidoDTO converterPedido(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        List<String> listaCodigo = new ArrayList<>();
        dto.setCodigoCliente(pedido.getCodigoCliente().toString());
        for (Integer cod:pedido.getCodigoProduto()) {
            listaCodigo.add(cod.toString());
        }
        dto.setCodigoProduto(listaCodigo);
        dto.setValorTotal(pedido.getValorTotal());
        dto.setEnderecoEntrega(pedido.getEnderecoEntrega());
        dto.setId(String.valueOf(pedido.getId()));
        return dto;
    }

}
