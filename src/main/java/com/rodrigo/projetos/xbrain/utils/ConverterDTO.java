package com.rodrigo.projetos.xbrain.utils;

import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;

public class ConverterDTO {


    public static Cliente converterClienteDto(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCodigo(Integer.parseInt(dto.getCodigo()));
        return cliente;
    }

    public static ClienteDTO converterCliente(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setNome(cliente.getNome());
        dto.setCodigo(cliente.getCodigo().toString());
        dto.setId(String.valueOf(cliente.getId()));
        return dto;
    }

}
