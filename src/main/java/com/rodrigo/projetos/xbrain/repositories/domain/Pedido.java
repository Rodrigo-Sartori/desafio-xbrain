package com.rodrigo.projetos.xbrain.repositories.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nm_codigo_cliente", nullable = false, length = 4)
    private Integer codigoCliente;

    @Column(name = "nm_codigos_produtos", nullable = false, length = 4)
    @ElementCollection
    private List<Integer> codigoProduto;

    @Column(name = "vl_valor_total", nullable = false)
    private BigDecimal valorTotal;

    @Column(name = "txt_endereco_entrega", nullable = false)
    private String enderecoEntrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public List<Integer> getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(List<Integer> codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", codigoCliente=" + codigoCliente +
                ", codigoProduto=" + codigoProduto +
                ", valorTotal=" + valorTotal +
                ", enderecoEntrega='" + enderecoEntrega + '\'' +
                '}';
    }
}
