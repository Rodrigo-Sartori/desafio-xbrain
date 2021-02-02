package com.rodrigo.projetos.xbrain.controller;


import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import com.rodrigo.projetos.xbrain.controllers.domain.TextoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


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
            Assertions.assertSame(response.getStatusCode(), HttpStatus.OK);
            System.out.println(response.getBody());
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName(value = "deve salvar cliente com sucesso")
    public void deveDeletarClientePeloCodigoComSucesso() {
        try {
           rest.delete(urlBase + "cliente/deletar/1111");
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }
}
