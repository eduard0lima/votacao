package br.com.sicredi.votacao.client;

import br.com.sicredi.votacao.VotacaoProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class CpfValidoClient {

    private final String DISPONIVEL_PARA_VOTO = "ABLE_TO_VOTE";
    private final VotacaoProperties votacaoProperties;

    public Boolean isCpfValido(String cpf) {
        var url = votacaoProperties.getUrlValidacaoCpf() + cpf;

        var response = new RestTemplate().getForEntity(url, Result.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return DISPONIVEL_PARA_VOTO.equals(response.getBody().getStatus());
        } else {
            return Boolean.FALSE;
        }

    }
}

@Getter
@Setter
class Result {
    private String status;
}
