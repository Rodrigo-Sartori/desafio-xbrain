package com.rodrigo.projetos.xbrain.controllers.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {

    private String id;

    @NotEmpty(message = "Código não pode ser vazio.")
    @Length(min = 4, max = 4,
            message = "Código deve conter 4 caracteres.")
    private String codigoCliente;

    @NotEmpty(message = "Código não pode ser vazio.")
    private List<String> codigoProduto;

    @NotNull(message = "Valor não pode ser vazio")
    private BigDecimal valorTotal;

    @NotEmpty(message = "Endereço de entrega não pode ser vazio.")
    @Length(min = 15, max = 70,
            message = "endereço deve conter entre 15 e 70 caracteres.")
    private String enderecoEntrega;

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public List<String> getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(List<String> codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
