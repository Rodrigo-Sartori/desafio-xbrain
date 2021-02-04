package com.rodrigo.projetos.xbrain.services;

import com.rodrigo.projetos.xbrain.controllers.domain.ClienteDTO;
import com.rodrigo.projetos.xbrain.execption.DefaultExeption;
import com.rodrigo.projetos.xbrain.repositories.ClienteRepository;
import com.rodrigo.projetos.xbrain.repositories.domain.Cliente;
import com.rodrigo.projetos.xbrain.utils.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRep;

    public Cliente salvar(ClienteDTO dto) throws DefaultExeption {
        Cliente cliente;
        try {
            cliente = clienteRep.save(ConverterDTO.converterClienteDto(dto));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DefaultExeption("ocorreu um erro ao salvar o cliente no banco: " + e.getClass());

        }
        return cliente;
    }

    public void deletar(Integer codigo) throws DefaultExeption {
        try {
            clienteRep.deleteByCodigo(codigo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DefaultExeption("ocorreu um erro ao deletar o cliente no banco: " + e.getClass());
        }
    }

    public List<Cliente> buscarTodos() throws DefaultExeption {
        try {
            List<Cliente> clientes = clienteRep.findAll();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DefaultExeption("ocorreu um erro ao buscar o cliente no banco: " + e.getClass());
        }
    }
}
