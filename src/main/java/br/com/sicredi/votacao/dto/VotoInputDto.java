package br.com.sicredi.votacao.dto;

import br.com.sicredi.votacao.domain.enumeration.SimNaoEnum;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel("VotoInput")
public class VotoInputDto {

    @NotNull
    private Long idPauta;

    @NotNull
    private Long idAssociado;

    private SimNaoEnum voto;

}
