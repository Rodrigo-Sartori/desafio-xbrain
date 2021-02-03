package com.rodrigo.projetos.xbrain.controller;


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


@DisplayName(value = "teste de controller da entidade produto")
public class ProdutoControllerTeste extends AbstractTesteController {

    private RestTemplate rest = new RestTemplate();

    private ProdutoDTO produto;

    @BeforeEach
    public void criarProduto() {
        produto = new ProdutoDTO();
        produto.setNome("produto teste");
        produto.setCodigo("1234");
        produto.setValor(new BigDecimal("9.99"));
    }

    @Test
    @DisplayName(value = "deve salvar produto com sucesso")
    public void deveSalvarProdutoComSucesso() {
        try {
            ResponseEntity<ProdutoDTO> response = rest.postForEntity(urlBase + "produto/salvar", produto, ProdutoDTO.class);
            Assertions.assertSame(response.getStatusCode(), HttpStatus.OK);
            System.out.println(response.getBody());
        } catch (RestClientException e) {
            Assertions.fail("Deveria ter salvo produto com sucesso: "+e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName(value = "deve salvar produto com sucesso")
    public void deveDeletarProdutoPeloCodigoComSucesso() {
        try {
            rest.delete(urlBase + "produto/deletar/1111");
        } catch (RestClientException e) {
            Assertions.fail("Deveria ter deletado produto com sucesso: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
