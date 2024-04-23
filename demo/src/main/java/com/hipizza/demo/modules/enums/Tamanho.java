package com.hipizza.demo.modules.enums;

public enum Tamanho {
    GRANDE("Grande"),
    MÉDIO("Médio"),
    PEQUENO("Pequeno");

    private final String tamanho;

    Tamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }
}
