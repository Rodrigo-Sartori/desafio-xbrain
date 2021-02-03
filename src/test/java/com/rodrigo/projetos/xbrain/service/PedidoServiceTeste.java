package com.rodrigo.projetos.xbrain.service;

import com.rodrigo.projetos.xbrain.controllers.domain.PedidoDTO;
import com.rodrigo.projetos.xbrain.controllers.domain.ProdutoDTO;
import com.rodrigo.projetos.xbrain.execption.DefaultExeption;
import com.rodrigo.projetos.xbrain.repositories.domain.Pedido;
import com.rodrigo.projetos.xbrain.repositories.domain.Produto;
import com.rodrigo.projetos.xbrain.services.PedidoService;
import com.rodrigo.projetos.xbrain.services.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName(value = "teste de repositório da entidade produto")
public class PedidoServiceTeste {

    @Autowired
    private PedidoService service;

    private PedidoDTO produtoTeste;

    public void criarPedido() {
        produtoTeste = new PedidoDTO();
        produtoTeste.setCodigoCliente("1111");
        List<String> lista = new ArrayList<>();
        lista.add("1111");
        lista.add("1111");
        produtoTeste.setCodigoProduto(lista);
        produtoTeste.setValorTotal(new BigDecimal(5));
        produtoTeste.setEnderecoEntrega("endereço de teste número 12345");
    }

    @BeforeEach
    public void preparador() {
        criarPedido();
    }

    @Test
    @DisplayName(value = "Não deve enviar pedido com cliente inexistente")
    public void naoDeveEnviarPedidoComClienteInexistente() {
        try {
            produtoTeste.setCodigoCliente("4321");
            service.enviar(produtoTeste);
        } catch (Exception e) {
            if (e instanceof DefaultExeption) {
                Assertions.assertNotNull(e.getMessage());
                System.out.println(e.getMessage());
            }else{
                Assertions.fail("Não deveveria ter enviado pedido com sucesso:" + e.getMessage());
            }
        }
    }

    @Test
    @DisplayName(value = "Não deve enviar pedido com produto inexistente")
    public void naaoDeveEnviarPedidoComProdutoInexistente() {
        try {
            List<String> lista = new ArrayList<>();
            lista.add("4321");
            produtoTeste.setCodigoProduto(lista);
            service.enviar(produtoTeste);
        } catch (Exception e) {
            if (e instanceof DefaultExeption) {
                Assertions.assertNotNull(e.getMessage());
                System.out.println(e.getMessage());
            }else{
                Assertions.fail("Não deveveria ter enviado pedido com sucesso:" + e.getMessage());
            }
        }
    }

    @Test
    @DisplayName(value = "Não deve enviar pedido com valor total errado")
    public void naoDeveEnviarPedidoComValorTotalErrado() {
        try {
            produtoTeste.setValorTotal(new BigDecimal("10"));
            service.enviar(produtoTeste);
        } catch (Exception e) {
            if (e instanceof DefaultExeption) {
                Assertions.assertNotNull(e.getMessage());
                System.out.println(e.getMessage());
            }else{
                Assertions.fail("Não deveveria ter enviado pedido com sucesso:" + e.getMessage());
            }
        }
    }

    @Test
    @DisplayName(value = "Deve enviar pedido com sucesso")
    public void deveInserirPedidoComSucesso() {
        try {
            Pedido pedido = service.enviar(produtoTeste);
            Assertions.assertNotNull(pedido);
            System.out.println(pedido);
        } catch (Exception e) {
            Assertions.fail("deveria ter inserido com sucesso:" + e.getMessage());
        }
    }


}
