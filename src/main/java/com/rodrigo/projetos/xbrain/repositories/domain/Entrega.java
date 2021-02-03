package com.rodrigo.projetos.xbrain.repositories.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "entrega")
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_pedido",length = 4)
    private Integer idPedido;

    @Column(name = "txt_endereco_entrega")
    private String enderecoEntrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", idPedido=" + idPedido +
                ", enderecoEntrega='" + enderecoEntrega + '\'' +
                '}';
    }
}
