package com.app.organizacao.teste.entity;

import com.app.organizacao.teste.entity.enums.TipoFuncionario;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "idfuncionario", referencedColumnName = "idpessoa")
public class Funcionario extends Pessoa {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpessoa")
    private Long id;

    @Column(name = "tipofuncionario")
    private TipoFuncionario tipofuncionario;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "setor")
    private String setor;

    public Funcionario() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public TipoFuncionario getTipofuncionario() {
        return tipofuncionario;
    }

    public void setTipofuncionario(TipoFuncionario tipofuncionario) {
        this.tipofuncionario = tipofuncionario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        if (!super.equals(o)) return false;
        Funcionario that = (Funcionario) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
}
