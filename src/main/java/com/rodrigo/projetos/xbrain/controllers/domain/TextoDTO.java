package com.rodrigo.projetos.xbrain.controllers.domain;

public class TextoDTO {

    private String texto;

    public TextoDTO() {
    }

    public TextoDTO(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "TextoDTO{" +
                "texto='" + texto + '\'' +
                '}';
    }
}
