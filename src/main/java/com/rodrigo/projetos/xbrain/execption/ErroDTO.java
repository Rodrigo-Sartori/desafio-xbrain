package com.rodrigo.projetos.xbrain.execption;

public class ErroDTO {

    String erro;

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    @Override
    public String toString() {
        return "ErroDTO{" +
                "erros=" + erro +
                '}';
    }
}
