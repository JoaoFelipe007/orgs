package com.app.organizacao.teste.entity.enums;

public enum TipoPagamento {

    CREDITO(0, "Credito"),
    DEBITO(1, "Debito"),
        BOLETO(2, "Boleto");

    private  int valor;
    private String descricao;



    private TipoPagamento(int valor, String descricao) {
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
