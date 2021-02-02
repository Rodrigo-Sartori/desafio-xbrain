package com.rodrigo.projetos.xbrain.services;

import com.rodrigo.projetos.xbrain.controllers.domain.ProdutoDTO;
import com.rodrigo.projetos.xbrain.execption.DefaultExeption;
import com.rodrigo.projetos.xbrain.repositories.ProdutoRepository;
import com.rodrigo.projetos.xbrain.repositories.domain.Produto;
import com.rodrigo.projetos.xbrain.utils.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRep;

    public Produto salvar(ProdutoDTO dto) throws DefaultExeption {
        Produto produto;
        try {
            produto = produtoRep.save(ConverterDTO.converterProdutoDto(dto));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DefaultExeption("ocorreu um erro ao salvar o produto no banco: " + e.getClass());
        }
        return produto;
    }

    public void deletar(Integer codigo) throws DefaultExeption {
        try {
            produtoRep.deleteByCodigo(codigo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DefaultExeption("ocorreu um erro ao deletar o produto no banco: " + e.getClass());
        }
    }
}
