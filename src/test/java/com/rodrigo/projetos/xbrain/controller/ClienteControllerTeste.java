package com.rodrigo.projetos.xbrain.controller;


import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@DisplayName(value = "teste de controller da entidade cliente")
public class ClienteControllerTeste extends AbstractTesteController {

    private RestTemplate rest = new RestTemplate();

    private ClienteDTO cliente;

    @BeforeEach
    public void criarCliente() {
        cliente = new ClienteDTO();
        cliente.setNome("cliente teste");
        cliente.setCodigo("1234");
    }

    @Test
    @DisplayName(value = "deve salvar cliente com sucesso")
    public void deveSalvarClienteComSucesso() {
        try {
            ResponseEntity<ClienteDTO> response = rest.postForEntity(urlBase + "cliente/salvar", cliente, ClienteDTO.class);
            Assertions.assertSame(response.getStatusCode(), HttpStatus.CREATED);
            System.out.println(response.getBody());
        } catch (RestClientException e) {
            Assertions.fail("Deveria ter salvo cliente com sucesso: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName(value = "deve salvar cliente com sucesso")
    public void deveDeletarClientePeloCodigoComSucesso() {
        try {
            rest.delete(urlBase + "cliente/deletar/1111");
        } catch (RestClientException e) {
            Assertions.fail("Deveria ter deletado cliente com sucesso: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName(value = "deve buscar todos os clientes com sucesso")
    public void deveBuscarProdutosComSucesso() {
        try {
            ResponseEntity<List> response = rest.getForEntity(urlBase + "cliente/buscar", List.class);
            Assertions.assertSame(response.getStatusCode(), HttpStatus.OK);
            System.out.println(response.getBody());
        } catch (RestClientException e) {
            Assertions.fail("Deveria ter buscado clientes com sucesso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
