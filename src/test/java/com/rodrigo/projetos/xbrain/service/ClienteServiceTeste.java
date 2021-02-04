package com.rodrigo.projetos.xbrain.service;

import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import com.rodrigo.projetos.xbrain.execption.DefaultExeption;
import com.rodrigo.projetos.xbrain.repositories.ClienteRepository;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import com.rodrigo.projetos.xbrain.services.ClienteService;
import com.rodrigo.projetos.xbrain.utils.ConverterDTO;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName(value = "teste de repositório da entidade cliente")
public class ClienteServiceTeste {

    @Autowired
    private ClienteService service;

    private ClienteDTO clienteTeste;

    private void criarCliente() {
        clienteTeste = new ClienteDTO();
        clienteTeste.setCodigo("4321");
        clienteTeste.setNome("pessoa teste");
    }

    @BeforeEach
    public void preparador() throws Exception {
        criarCliente();
    }

    @Test
    @DisplayName(value = "Deve inserir cliente com sucesso")
    public void deveInserirClienteComSucesso() {
        try {
            Cliente cliente = service.salvar(clienteTeste);
            Assertions.assertNotNull(cliente);
            System.out.println(cliente);
        } catch (Exception e) {
            System.out.println("deveria ter inserido com sucesso:" + e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "Deve deletar cliente com sucesso")
    public void deveDeletarClienteComSucesso()  {
        try {
            Cliente cliente = service.salvar(clienteTeste);
            service.deletar(cliente.getCodigo());
        } catch (Exception e) {
            System.out.println("deveria ter deletado com sucesso:" + e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "Deve buscar todos clientes com sucesso")
    public void deveBuscarTodosClientesComSucesso()  {
        try {
            List<Cliente> clientes = service.buscarTodos();
            Assertions.assertFalse(clientes.isEmpty());
            System.out.println(clientes.toString());
        } catch (Exception e) {
            System.out.println("deveria ter deletado com sucesso:" + e.getMessage());
        }
    }

}
