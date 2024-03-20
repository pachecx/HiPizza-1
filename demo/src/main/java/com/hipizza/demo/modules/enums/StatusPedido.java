package com.hipizza.demo.modules.enums;

public enum StatusPedido {
    CONFIRMADO("Confirmado"),
    FAZENDO("Fazendo"),
    PRONTO("Pronto"),
    ENTREGANDO("Entregando"),
    ENTREGUE("Entregue");

    private final String status_pedido;

    StatusPedido(String status_pedido) {
        this.status_pedido = status_pedido;
    }

    public String getStatus_pedido() {
        return status_pedido;
    }
}
