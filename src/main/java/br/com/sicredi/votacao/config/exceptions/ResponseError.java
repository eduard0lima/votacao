package br.com.sicredi.votacao.config.exceptions;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Erro")
public class ResponseError {

    private ExceptionEnum code;
    private String description;
    private Map<String, String> fields = new HashMap<>();

    public ResponseError(ExceptionEnum code, String description) {
        this.code = code;
        this.description = description;
    }
}
