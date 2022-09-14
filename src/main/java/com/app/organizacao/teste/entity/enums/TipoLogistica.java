package com.app.organizacao.teste.entity.enums;

public enum TipoLogistica {

    ARMAZENAGEM(0, "Externo"),
    ESTOQUE(1, "Interno"),
    PROCESSAMENTO_PEDIDOS(2,"Processamento de pedidos");
    private  int valor;
    private String descricao;



    private TipoLogistica(int valor, String descricao) {
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
