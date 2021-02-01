package com.rodrigo.projetos.xbrain.services;

import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import com.rodrigo.projetos.xbrain.repositories.repository.ClienteRepository;
import com.rodrigo.projetos.xbrain.utils.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRep;

    public Cliente salvar(ClienteDTO dto) {
        Cliente cliente = ConverterDTO.converterClienteDto(dto);
        return clienteRep.save(cliente);
    }
}
