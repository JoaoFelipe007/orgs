package com.app.organizacao.teste.entity;

import com.app.organizacao.teste.entity.enums.TipoVendedor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "vendedor")
@PrimaryKeyJoinColumn(name = "idvendedor", referencedColumnName = "idpessoa")
public class Vendedor extends Pessoa {

    @Column(name = "tipovendedor")
    private TipoVendedor tipoVendedor;

    @Column(name = "salario")
    private BigDecimal salario;
    public Vendedor() {
    }

    public TipoVendedor getTipoVendedor() {
        return tipoVendedor;
    }

    public void setTipoVendedor(TipoVendedor tipoVendedor) {
        this.tipoVendedor = tipoVendedor;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
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
