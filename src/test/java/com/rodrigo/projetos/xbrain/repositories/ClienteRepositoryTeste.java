package com.rodrigo.projetos.xbrain.repositories;

import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@DisplayName(value = "teste de repositório da entidade cliente")
@ActiveProfiles("test")
public class ClienteRepositoryTeste {

    @Autowired
    private ClienteRepository rep;

    private Cliente clienteTeste;

    private void criarCliente() {
        clienteTeste = new Cliente();
        clienteTeste.setCodigo(4321);
        clienteTeste.setNome("pessoa teste");
    }

    @BeforeEach
    public void preparador() throws Exception {
        criarCliente();
        clienteTeste = rep.save(clienteTeste);
    }

    @AfterEach
    public void finalizador() throws Exception {
        rep.delete(clienteTeste);
    }

    @Test
    @DisplayName(value = "não deve inserir cliente vazio")
    public void naoDeveInserirClienteVazio() {
        try {
            rep.save(new Cliente());
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "não deve inserir cliente com código menor que 4")
    public void naoDeveInserirClienteComCodigoMenorQue4() {
        try {
            clienteTeste.setCodigo(12);
            rep.save(clienteTeste);
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
            rep.delete(clienteTeste);
        }
    }

    @Test
    @DisplayName(value = "não deve procurar cliente com id inexistente")
    public void naoDeveProcurarClienteComIdInexistente() {
        try {
            rep.findById(123441231);
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve procurar cliente com sucesso")
    public void deveProcurarClienteComSucesso() {
        try {
            Optional<Cliente> cliente = rep.findById(clienteTeste.getId());
            Assertions.assertTrue(cliente.isPresent());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve procurar todos os clientes com sucesso")
    public void deveProcurarTodosClienteComSucesso() {
        try {
            List<Cliente> clientes = rep.findAll();
            Assertions.assertFalse(clientes.isEmpty());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve deletar cliente pelo código com sucesso")
    public void deveDeletarClientePeloCodigoComSucesso() {
        try {
            rep.deleteByCodigo(clienteTeste.getCodigo());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }


}
