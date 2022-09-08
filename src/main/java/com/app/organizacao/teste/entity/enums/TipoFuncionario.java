package com.app.organizacao.teste.entity.enums;

public enum TipoFuncionario {
    VENDEDOR(1, "Vendedor"),
    LOGISTICA(2, "Pessoa Juridica"),
    ADM(3, "ADM"),
    FINANCEIRO(2, "Financeiro");

    private  int valor;
    private String descricao;



    private TipoFuncionario(int valor, String descricao) {
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
