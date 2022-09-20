package br.com.sicredi.votacao.config.exceptions;

import lombok.Getter;

@Getter
public class CustomRestException extends RuntimeException {

    private final ExceptionEnum exceptionCode;
    private String[] parameters;

    public CustomRestException(ExceptionEnum exceptionCode, Exception ex) {
        super(exceptionCode.getMessage(), ex);
        this.exceptionCode = exceptionCode;
    }

    public CustomRestException(ExceptionEnum exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }

    public CustomRestException(ExceptionEnum exceptionCode, String... parameters) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
        this.parameters = parameters;
    }
}
