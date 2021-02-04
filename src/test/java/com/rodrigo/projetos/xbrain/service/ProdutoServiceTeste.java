package com.rodrigo.projetos.xbrain.service;

import com.rodrigo.projetos.xbrain.controllers.domain.ProdutoDTO;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import com.rodrigo.projetos.xbrain.repositories.domain.Produto;
import com.rodrigo.projetos.xbrain.services.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName(value = "teste de repositório da entidade produto")
public class ProdutoServiceTeste {

    @Autowired
    private ProdutoService service;

    private ProdutoDTO produtoTeste;

    private void criarProduto() {
        produtoTeste = new ProdutoDTO();
        produtoTeste.setCodigo("4321");
        produtoTeste.setNome("produto teste");
        produtoTeste.setValor(new BigDecimal("12.90"));
    }

    @BeforeEach
    public void preparador() throws Exception {
        criarProduto();
    }

    @Test
    @DisplayName(value = "Deve inserir produto com sucesso")
    public void deveInserirProdutoComSucesso() {
        try {
            Produto produto = service.salvar(produtoTeste);
            Assertions.assertNotNull(produto);
            System.out.println(produto);
        } catch (Exception e) {
            Assertions.fail("deveria ter inserido com sucesso:" + e.getMessage());
        }
    }


    @Test
    @DisplayName(value = "Deve deletar produto com sucesso")
    public void deveDeletarProdutoComSucesso()  {
        try {
            produtoTeste.setCodigo("1235");
            Produto produto = service.salvar(produtoTeste);
            service.deletar(produto.getCodigo());
        } catch (Exception e) {
            Assertions.fail("deveria ter deletado com sucesso:" + e.getMessage());
        }
    }


    @Test
    @DisplayName(value = "Deve todos os produtos com sucesso")
    public void deveBuscarTodosProdutoComSucesso()  {
        try {
            List<Produto> produtos = service.buscarTodos();
            Assertions.assertFalse(produtos.isEmpty());
            System.out.println(produtos.toString());
        } catch (Exception e) {
            Assertions.fail("deveria ter buscado com sucesso:" + e.getMessage());
        }
    }

}
