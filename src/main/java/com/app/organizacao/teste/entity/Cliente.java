package com.app.organizacao.teste.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "idcliente", referencedColumnName = "idpessoa")
public class Cliente {
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



}
