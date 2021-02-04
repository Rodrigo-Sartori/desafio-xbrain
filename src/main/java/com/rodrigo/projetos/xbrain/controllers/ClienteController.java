package com.rodrigo.projetos.xbrain.controllers;

import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import com.rodrigo.projetos.xbrain.controllers.domain.TextoDTO;
import com.rodrigo.projetos.xbrain.execption.DefaultExeption;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import com.rodrigo.projetos.xbrain.services.ClienteService;
import com.rodrigo.projetos.xbrain.utils.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/salvar")
    public ResponseEntity<ClienteDTO> salvarCliente(@Valid @RequestBody ClienteDTO clienteDto) throws DefaultExeption {
        try {
            Cliente cliente = service.salvar(clienteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(ConverterDTO.converterCliente(cliente));
        } catch (Exception e) {
            if (e instanceof DefaultExeption){
                throw e;
            }else{
                e.printStackTrace();
                throw new DefaultExeption("ocorreu um erro ao salvar cliente na controller");
            }
        }
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<TextoDTO> deletarCliente(@PathVariable("codigo") Integer codigo) throws DefaultExeption {
        try {
            service.deletar(codigo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new TextoDTO("cliente deletado com sucesso"));
        }catch (Exception e) {
            if (e instanceof DefaultExeption){
                throw e;
            }else{
                e.printStackTrace();
                throw new DefaultExeption("ocorreu um erro ao deletar cliente na controller");
            }
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteDTO>> deletarCliente() throws DefaultExeption {
        try {
            List<Cliente> clientes =service.buscarTodos();
            return ResponseEntity.ok().body(ConverterDTO.converterClientes(clientes));
        }catch (Exception e) {
            if (e instanceof DefaultExeption){
                throw e;
            }else{
                e.printStackTrace();
                throw new DefaultExeption("ocorreu um erro ao salvar cliente na controller");
            }
        }
    }
}
