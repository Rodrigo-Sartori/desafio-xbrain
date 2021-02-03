package com.rodrigo.projetos.xbrain.listener;

import com.rodrigo.projetos.xbrain.repositories.domain.Pedido;
import org.springframework.stereotype.Component;

@Component
public class Recebedor {

    public void receberMensagem(Pedido mensagem){
        System.out.println("mensagem recebida com sucesso "+ mensagem.toString());
    }
}
