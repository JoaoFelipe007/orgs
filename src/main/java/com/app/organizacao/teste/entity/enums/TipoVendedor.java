package com.app.organizacao.teste.entity.enums;

public enum TipoVendedor {
    EXTERNO(0, "Externo"),
    INTERNO(1, "Interno");
    private  int valor;
    private String descricao;



    private TipoVendedor(int valor, String descricao) {
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
