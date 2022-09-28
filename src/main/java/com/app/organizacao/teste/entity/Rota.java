package com.app.organizacao.teste.entity;

import javax.persistence.*;

@Entity
@Table(name="rota")
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrota")
    private Long id;



    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private Cliente cliente;

    @Column(name = "cep")
    private String cep;

    @Column(name = "rua")
    private String rua;

    @Column(name = "bairro")
    private String bairro;

    @Column(name="numerocasa")
    private Integer numeroCasa;

    @Column(name = "diasemanaentrega")
    private Integer diaSemanaEntrega;

    public Rota() {
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public Integer getDiaSemanaEntrega() {
        return diaSemanaEntrega;
    }

    public void setDiaSemanaEntrega(Integer diaSemanaEntrega) {
        this.diaSemanaEntrega = diaSemanaEntrega;
    }
}
