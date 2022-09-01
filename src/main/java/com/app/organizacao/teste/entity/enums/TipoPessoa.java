package com.app.organizacao.teste.entity.enums;

public enum TipoPessoa {
    PESSOA_FISICA(1, "Pessoa Fisica"),
    PESSOA_JURIDICA(2, "Pessoa Juridica");

    private  int valor;
    private String descricao;



    private TipoPessoa(int valor, String descricao) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
