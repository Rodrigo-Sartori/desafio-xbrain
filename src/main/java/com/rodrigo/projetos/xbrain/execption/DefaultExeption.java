package com.rodrigo.projetos.xbrain.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DefaultExeption extends Exception{

    public DefaultExeption() {
        super();
    }
    public DefaultExeption(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    public DefaultExeption(String mensagem) {
        super(mensagem);
    }
    public DefaultExeption(Throwable causa) {
        super(causa);
    }
}
