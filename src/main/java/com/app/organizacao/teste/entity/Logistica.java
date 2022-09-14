package com.app.organizacao.teste.entity;

import com.app.organizacao.teste.entity.enums.TipoLogistica;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "logistica")
@PrimaryKeyJoinColumn(name = "idlogistica", referencedColumnName = "idpessoa")
public class Logistica extends Pessoa {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlogistica")
    private Long id;

    @Column(name = "tipovendedor")
    private TipoLogistica tipoLogistica;

    public Logistica() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public TipoLogistica getTipoLogistica() {
        return tipoLogistica;
    }

    public void setTipoLogistica(TipoLogistica tipoLogistica) {
        this.tipoLogistica = tipoLogistica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Logistica)) return false;
        if (!super.equals(o)) return false;
        Logistica logistica = (Logistica) o;
        return getId().equals(logistica.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
}
