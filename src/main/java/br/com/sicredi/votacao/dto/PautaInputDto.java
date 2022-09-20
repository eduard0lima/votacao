package br.com.sicredi.votacao.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ApiModel("PautaInput")
public class PautaInputDto {

    @NotBlank
    @Size(max = 100)
    private String nome;

    @Size(max = 300)
    private String descricao;

}
