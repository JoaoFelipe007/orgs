package com.app.organizacao.teste.entity;

import com.app.organizacao.teste.entity.enums.TipoVendedor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vendedor")
@PrimaryKeyJoinColumn(name = "idvendedor", referencedColumnName = "idpessoa")
public class Vendedor extends Pessoa {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvendedor")
    private Long id;

    @Column(name = "tipovendedor")
    private TipoVendedor tipoVendedor;


    public Vendedor() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public TipoVendedor getTipoVendedor() {
        return tipoVendedor;
    }

    public void setTipoVendedor(TipoVendedor tipoVendedor) {
        this.tipoVendedor = tipoVendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendedor)) return false;
        if (!super.equals(o)) return false;
        Vendedor that = (Vendedor) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
}
