package br.com.sicredi.votacao.service;

import br.com.sicredi.votacao.VotacaoProperties;
import br.com.sicredi.votacao.client.CpfValidoClient;
import br.com.sicredi.votacao.config.exceptions.CustomRestException;
import br.com.sicredi.votacao.config.exceptions.ExceptionEnum;
import br.com.sicredi.votacao.domain.Associado;
import br.com.sicredi.votacao.domain.Sessao;
import br.com.sicredi.votacao.domain.Voto;
import br.com.sicredi.votacao.dto.VotoInputDto;
import br.com.sicredi.votacao.repository.AssociadoRepository;
import br.com.sicredi.votacao.repository.SessaoRepository;
import br.com.sicredi.votacao.repository.VotoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VotoService {

    @Getter
    public final VotoRepository repository;
    private final CpfValidoClient cpfValidoClient;
    private final SessaoRepository sessaoRepository;
    private final AssociadoRepository associadoRepository;
    private final MapperFacade mapper;

    public Voto insert(VotoInputDto votoInputDto) {
        Voto voto = mapper.map(votoInputDto, Voto.class);
        validarVoto(votoInputDto, voto);
        return repository.save(voto);
    }
    private void validarVoto(VotoInputDto votoInputDto, Voto voto) {
        if (repository.existsBySessaoPautaIdAndAssociadoId(votoInputDto.getIdPauta(), votoInputDto.getIdAssociado())) {
            throw new CustomRestException(ExceptionEnum.VOTACAO_004, votoInputDto.getIdAssociado().toString());
        }
        Associado associado = associadoRepository.findById(votoInputDto.getIdAssociado())
                .orElseThrow(() -> new CustomRestException(ExceptionEnum.VOTACAO_001, votoInputDto.getIdAssociado().toString()));
        Sessao sessao = sessaoRepository.findByPautaId(votoInputDto.getIdPauta())
                .orElseThrow(() -> new CustomRestException(ExceptionEnum.VOTACAO_002, votoInputDto.getIdAssociado().toString()));

        if (!sessao.isAberta()) {
            throw new CustomRestException(ExceptionEnum.VOTACAO_002, votoInputDto.getIdAssociado().toString());
        }

        if (!cpfValidoClient.isCpfValido(associado.getCpf())) {
            throw new CustomRestException(ExceptionEnum.VOTACAO_005, votoInputDto.getIdAssociado().toString());
        }

        voto.setSessao(sessao);
    }

}
