package com.rodrigo.projetos.xbrain.repositories;

import com.rodrigo.projetos.xbrain.repositories.domain.Produto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@DisplayName(value = "teste de repositório da entidade produto")
@ActiveProfiles("test")
public class ProdutoRepositoryTeste {

    @Autowired
    private ProdutoRepository rep;

    private Produto produtoTeste;

    private void criarProduto() {
        produtoTeste = new Produto();
        produtoTeste.setCodigo(4321);
        produtoTeste.setNome("pessoa teste");
        produtoTeste.setValor(new BigDecimal("12.90"));
    }

    @BeforeEach
    public void preparador() throws Exception {
        criarProduto();
        produtoTeste = rep.save(produtoTeste);
    }

    @AfterEach
    public void finalizador() throws Exception {
        rep.delete(produtoTeste);
    }

    @Test
    @DisplayName(value = "não deve inserir produto vazio")
    public void naoDeveInserirProdutoVazio() {
        try {
            rep.save(new Produto());
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "não deve inserir produto com código menor que 4")
    public void naoDeveInserirProdutoComCodigoMenorQue4() {
        try {
            produtoTeste.setCodigo(12);
            rep.save(produtoTeste);
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
            rep.delete(produtoTeste);
        }
    }

    @Test
    @DisplayName(value = "não deve procurar produto com id inexistente")
    public void naoDeveProcurarProdutoComIdInexistente() {
        try {
            rep.findById(123441231);
        } catch (Exception e) {
            Assertions.assertNotNull(e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve procurar produto com sucesso")
    public void deveProcurarProdutoComSucesso() {
        try {
            Optional<Produto> produto = rep.findById(produtoTeste.getId());
            Assertions.assertTrue(produto.isPresent());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve procurar todos os produtos com sucesso")
    public void deveProcurarTodosProdutosComSucesso() {
        try {
            List<Produto> produtos = rep.findAll();
            Assertions.assertFalse(produtos.isEmpty());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }

    @Test
    @DisplayName(value = "deve deletar produto pelo código com sucesso")
    public void deveDeletarProdutoPeloCodigoComSucesso() {
        try {
            rep.deleteByCodigo(produtoTeste.getCodigo());
        } catch (Exception e) {
            System.out.println("deveria ter procurado com sucesso: " + e.getMessage());
        }
    }


}
