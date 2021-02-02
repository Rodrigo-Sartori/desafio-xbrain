package com.rodrigo.projetos.xbrain.controllers;

import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import com.rodrigo.projetos.xbrain.controllers.domain.ProdutoDTO;
import com.rodrigo.projetos.xbrain.controllers.domain.TextoDTO;
import com.rodrigo.projetos.xbrain.execption.DefaultExeption;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import com.rodrigo.projetos.xbrain.repositories.domain.Produto;
import com.rodrigo.projetos.xbrain.services.ClienteService;
import com.rodrigo.projetos.xbrain.services.ProdutoService;
import com.rodrigo.projetos.xbrain.utils.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/salvar")
    public ResponseEntity<ProdutoDTO> salvar(@Valid @RequestBody ProdutoDTO produtoDTO) throws DefaultExeption {
        try {
            Produto produto = service.salvar(produtoDTO);
            return ResponseEntity.ok(ConverterDTO.converterProduto(produto));
        } catch (Exception e) {
            if (e instanceof DefaultExeption){
                throw e;
            }else{
                e.printStackTrace();
                throw new DefaultExeption("ocorreu um erro na classe de rest");
            }
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<TextoDTO> deletar(@PathVariable("codigo") Integer codigo) throws DefaultExeption {
        try {
            service.deletar(codigo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new TextoDTO("cliente deletado com sucesso"));
        }catch (Exception e) {
            if (e instanceof DefaultExeption){
                throw e;
            }else{
                e.printStackTrace();
                throw new DefaultExeption("ocorreu um erro na classe de rest");
            }
        }
    }
}
