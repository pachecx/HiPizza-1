package com.hipizza.demo.modules.enums;

public enum FormaPagamento {
    CRÉDITO("Crédito"),
    DÉBITO("Débito"),
    DINHEIRO("Dinheiro"),
    PIX("Pix");

    private final String forma_pagamento;

    FormaPagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }
}
