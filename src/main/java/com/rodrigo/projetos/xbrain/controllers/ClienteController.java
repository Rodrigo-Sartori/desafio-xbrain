package com.rodrigo.projetos.xbrain.controllers;

import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import com.rodrigo.projetos.xbrain.execption.ResponseExeption;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import com.rodrigo.projetos.xbrain.services.ClienteService;
import com.rodrigo.projetos.xbrain.utils.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/salvar")
    public ResponseEntity<ClienteDTO> salvarCliente(@Valid @RequestBody ClienteDTO clienteDto) {
        try {
            Cliente cliente = service.salvar(clienteDto);
            return ResponseEntity.ok(ConverterDTO.converterCliente(cliente));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseExeption("erro");
        }

    }
}
