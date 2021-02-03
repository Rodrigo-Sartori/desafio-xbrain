package com.rodrigo.projetos.xbrain.repositories;

import com.rodrigo.projetos.xbrain.repositories.domain.Entrega;
import com.rodrigo.projetos.xbrain.repositories.domain.Produto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@DisplayName(value = "teste de repositório da entidade entrega")
@ActiveProfiles("test")
public class EntregaRepositoryTeste {

    @Autowired
    private EntregaRepository rep;

    private Entrega entregaTeste;

    private void criarEntrega() {
        entregaTeste = new Entrega();
        entregaTeste.setIdPedido(4321);
        entregaTeste.setEnderecoEntrega("endereço de entrega numero 1");
    }

    @BeforeEach
    public void preparador() throws Exception {
        criarEntrega();
        entregaTeste = rep.save(entregaTeste);
    }

    @AfterEach
    public void finalizador() throws Exception {
        rep.delete(entregaTeste);
    }

    @Test
    @DisplayName(value = "não deve inserir entrega vazio")
    public void naoDeveInserirEntregaVazio() {
        try {
            rep.save(new Entrega());
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "não deve inserir entrega com id de pedido menor que 4")
    public void naoDeveInserirEntregaComCodigoMenorQue4() {
        try {
            entregaTeste.setIdPedido(12);
            rep.save(entregaTeste);
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "não deve procurar entrega com id inexistente")
    public void naoDeveProcurarEntregaComIdInexistente() {
        try {
            rep.findById(123441231);
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve procurar entrega com sucesso")
    public void deveProcurarEntregaComSucesso() {
        try {
            Optional<Entrega> entrega = rep.findById(entregaTeste.getId());
            Assertions.assertTrue(entrega.isPresent());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve procurar todas as entregas com sucesso")
    public void deveProcurarTodosProdutosComSucesso() {
        try {
            List<Entrega> entregas = rep.findAll();
            Assertions.assertFalse(entregas.isEmpty());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }

}
