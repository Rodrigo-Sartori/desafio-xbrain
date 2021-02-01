package com.rodrigo.projetos.xbrain.controllers.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class ClienteDTO {

    private String id;

    @NotEmpty(message = "Nome não pode ser vazio.")
    @Length(min = 5, max = 160,
            message = "Nome deve conter entre 5 e 100 caracteres.")
    private String nome;

    @NotEmpty(message = "Código não pode ser vazio.")
    @Length(min = 4, max = 4,
            message = "Código deve conter 4 caracteres.")
    private String codigo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
