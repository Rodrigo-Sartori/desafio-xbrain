package com.rodrigo.projetos.xbrain.controller;


import com.rodrigo.projetos.xbrain.controllers.domain.PedidoDTO;
import com.rodrigo.projetos.xbrain.controllers.domain.ProdutoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@DisplayName(value = "teste de controller da entidade pedido")
public class PedidoControllerTeste extends AbstractTesteController {

    private RestTemplate rest = new RestTemplate();

    private PedidoDTO pedido;

    @BeforeEach
    public void criarPedido() {
        pedido = new PedidoDTO();
        pedido.setCodigoCliente("1111");
        List<String> lista = new ArrayList<>();
        lista.add("1111");
        lista.add("1111");
        pedido.setCodigoProduto(lista);
        pedido.setValorTotal(new BigDecimal(5));
        pedido.setEnderecoEntrega("endereço de teste número 12345");
    }

    @Test
    @DisplayName(value = "deve salvar produto com sucesso")
    public void deveSalvarProdutoComSucesso() {
        try {
            ResponseEntity<String> response = rest.postForEntity(urlBase + "pedido/enviar", pedido, String.class);
            Assertions.assertSame(response.getStatusCode(), HttpStatus.OK);
            System.out.println(response.getBody());
        } catch (RestClientException e) {
            Assertions.fail("Deveria ter enviado pedido com sucesso: "+e.getMessage());
            e.printStackTrace();
        }
    }

}
