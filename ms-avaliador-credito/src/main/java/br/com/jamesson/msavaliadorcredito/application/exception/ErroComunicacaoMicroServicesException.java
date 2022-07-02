package br.com.jamesson.msavaliadorcredito.application.exception;

import lombok.Getter;

public class ErroComunicacaoMicroServicesException extends Exception {

    @Getter
    private Integer status;

    public ErroComunicacaoMicroServicesException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }
}
