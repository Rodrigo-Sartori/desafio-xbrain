package com.rodrigo.projetos.xbrain.listener;

import com.rodrigo.projetos.xbrain.repositories.EntregaRepository;
import com.rodrigo.projetos.xbrain.repositories.domain.Entrega;
import com.rodrigo.projetos.xbrain.repositories.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Recebedor {

    @Autowired
    private EntregaRepository rep;

    public void receberMensagem(Pedido mensagem){
        Entrega entrega = new Entrega();
        try {
            entrega.setIdPedido(mensagem.getId());
            entrega.setEnderecoEntrega(mensagem.getEnderecoEntrega());
            rep.save(entrega);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
