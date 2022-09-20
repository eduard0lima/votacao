package br.com.sicredi.votacao.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel("SessaoInput")
public class SessaoInputDto {

    @NotNull
    private Long idPauta;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime fim;

}
