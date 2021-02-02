package com.rodrigo.projetos.xbrain.execption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = {RestController.class})
public class ControladorExcecaoRest {
    @ExceptionHandler({DefaultExeption.class})
    public ResponseEntity<ErroDTO> handleBindingErrors(DefaultExeption ex) {
        ErroDTO erro =  new ErroDTO();
        erro.setErro(ex.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }
}
