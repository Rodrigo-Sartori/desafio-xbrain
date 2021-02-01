package com.rodrigo.projetos.xbrain.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResponseExeption extends RuntimeException{

    public ResponseExeption() {
        super();
    }
    public ResponseExeption(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    public ResponseExeption(String mensagem) {
        super(mensagem);
    }
    public ResponseExeption(Throwable causa) {
        super(causa);
    }
}
