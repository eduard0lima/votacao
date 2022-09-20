package br.com.sicredi.votacao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("votacao")
public class VotacaoProperties {
    private String urlValidacaoCpf;
}


