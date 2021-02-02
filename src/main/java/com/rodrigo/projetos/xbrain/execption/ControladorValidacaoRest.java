package com.rodrigo.projetos.xbrain.execption;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = {RestController.class})
public class ControladorValidacaoRest {
    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErroDTO> handleBindingErrors(Exception ex) {
        ErroDTO erro =  new ErroDTO();
        erro.setErro(ex.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }
}
