package br.com.sicredi.votacao.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("ResultadoOutput")
public class ResultadoOutputDto {

    private Long idPauta;
    private Long totalSim;
    private Long totalNao;

}
