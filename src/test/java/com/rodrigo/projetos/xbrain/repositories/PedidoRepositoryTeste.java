package com.rodrigo.projetos.xbrain.repositories;

import com.rodrigo.projetos.xbrain.repositories.domain.Pedido;
import com.rodrigo.projetos.xbrain.repositories.domain.Produto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@DisplayName(value = "teste de repositório da entidade produto")
@ActiveProfiles("test")
public class PedidoRepositoryTeste {

    @Autowired
    private PedidoRepository rep;

    private Pedido pedidoTeste;

    private void criarPedido() {
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
    public void preparador() throws Exception {
        criarPedido();
        pedidoTeste = rep.save(pedidoTeste);
    }

    @AfterEach
    public void finalizador() throws Exception {
        rep.delete(pedidoTeste);
    }

    @Test
    @DisplayName(value = "não deve inserir pedido vazio")
    public void naoDeveInserirPedidoVazio() {
        try {
            rep.save(new Pedido());
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "não deve procurar pedido com id inexistente")
    public void naoDeveProcurarPedidoComIdInexistente() {
        try {
            rep.findById(123441231);
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve procurar pedido com sucesso")
    public void deveProcurarPedidoComSucesso() {
        try {
            Optional<Pedido> pedido = rep.findById(pedidoTeste.getId());
            Assertions.assertTrue(pedido.isPresent());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve procurar todos os pedidos com sucesso")
    public void deveProcurarTodosPedidosComSucesso() {
        try {
            List<Pedido> pedidos = rep.findAll();
            Assertions.assertFalse(pedidos.isEmpty());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }

}
