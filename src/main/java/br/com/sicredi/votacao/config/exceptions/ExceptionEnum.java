package br.com.sicredi.votacao.config.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionEnum {

    VOTACAO_001("id.associado.nao.encontrado", HttpStatus.BAD_REQUEST),
    VOTACAO_002("id.pauta.nao.encontrado", HttpStatus.BAD_REQUEST),
    VOTACAO_003("sessao.duplicada", HttpStatus.BAD_REQUEST),
    VOTACAO_004("associado.ja.votou", HttpStatus.BAD_REQUEST),
    VOTACAO_005("cpf.invalido.votacao", HttpStatus.NOT_FOUND);


    private final String message;
    private final HttpStatus httpStatus;

    ExceptionEnum(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
