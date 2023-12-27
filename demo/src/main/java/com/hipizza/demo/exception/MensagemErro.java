package com.hipizza.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemErro {

    private final String error;
    private final String message;

    public MensagemErro(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
