package com.app.organizacao.teste.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "idcliente", referencedColumnName = "idpessoa")
public class Cliente extends Pessoa{
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idvendedor", referencedColumnName = "idvendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "idrota", referencedColumnName = "idrota")
    private Rota rota;


    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
}
