package com.app.organizacao.teste.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "financeiro")
@PrimaryKeyJoinColumn(name = "idfinanceiro", referencedColumnName = "idpessoa")
public class Financeiro extends Pessoa {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfinanceiro")
    private Long id;

    public Financeiro() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Financeiro)) return false;
        if (!super.equals(o)) return false;
        Financeiro that = (Financeiro) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
}
