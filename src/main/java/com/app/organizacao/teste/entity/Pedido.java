package com.app.organizacao.teste.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpedido")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idproduto", referencedColumnName = "idproduto")
    private Produto produto;

    @Column(name = "valortotal")
    private BigDecimal valorTotal;

    @Column(name = "desconto")
    private BigDecimal desconto;

    @ManyToOne
    @JoinColumn(name = "idvendedor", referencedColumnName = "idvendedor")
    private Vendedor vendedor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "datacadastro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataCadastro;

    @Column(name = "entregue")
    private Boolean entregue;

    @Column(name = "pago")
    private Boolean pago;

    @Column(name = "diapagamentoefetuado")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date diaPagamentoEfetuado;

    @Column(name = "tipopagamento")
    private Integer tipoPagamento;

    @Column(name = "totalparcelas")
    private Integer totalParcelas;

    @Column(name = "totalparcelaspagas")
    private Integer totalPacelasPagas;


    @PrePersist
    public void prepersist() {
        this.dataCadastro = new Date();
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Date getDiaPagamentoEfetuado() {
        return diaPagamentoEfetuado;
    }

    public void setDiaPagamentoEfetuado(Date diaPagamentoEfetuado) {
        this.diaPagamentoEfetuado = diaPagamentoEfetuado;
    }

    public Integer getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Integer tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Integer getTotalParcelas() {
        return totalParcelas;
    }

    public void setTotalParcelas(Integer totalParcelas) {
        this.totalParcelas = totalParcelas;
    }

    public Integer getTotalPacelasPagas() {
        return totalPacelasPagas;
    }

    public void setTotalPacelasPagas(Integer totalPacelasPagas) {
        this.totalPacelasPagas = totalPacelasPagas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
