package br.com.sicredi.votacao.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel("AssociadoInput")
public class AssociadoInputDto {

    @NotBlank
    @Size(max = 100)
    private String nome;

    @CPF
    @NotBlank
    @Size(max = 11)
    private String cpf;

}
