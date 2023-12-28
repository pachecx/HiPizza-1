package com.hipizza.demo.enums;

public enum StatusPedido {
    FAZENDO("Fazendo"),
    PRONTO("Pronto"),
    ENTREGANDO("Entregando"),
    ENTREGUE("Entregue");

    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
