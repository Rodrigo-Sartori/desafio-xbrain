package com.rodrigo.projetos.xbrain.controllers;

import com.rodrigo.projetos.xbrain.controllers.domain.PedidoDTO;
import com.rodrigo.projetos.xbrain.controllers.domain.TextoDTO;
import com.rodrigo.projetos.xbrain.execption.DefaultExeption;
import com.rodrigo.projetos.xbrain.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviar(@Valid @RequestBody PedidoDTO pedidoDTO) throws DefaultExeption {
        try {
            service.enviar(pedidoDTO);
            return ResponseEntity.ok().body("Pedido feito com sucesso");
        } catch (Exception e) {
            if (e instanceof DefaultExeption){
                throw e;
            }else{
                e.printStackTrace();
                throw new DefaultExeption("ocorreu um erro na classe de rest");
            }
        }
    }
}
