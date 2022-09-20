package br.com.sicredi.votacao.service;

import br.com.sicredi.votacao.domain.Pauta;
import br.com.sicredi.votacao.domain.Voto;
import br.com.sicredi.votacao.domain.enumeration.SimNaoEnum;
import br.com.sicredi.votacao.dto.PaginaDto;
import br.com.sicredi.votacao.dto.PautaInputDto;
import br.com.sicredi.votacao.dto.ResultadoOutputDto;
import br.com.sicredi.votacao.repository.PautaRepository;
import br.com.sicredi.votacao.repository.VotoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PautaService {

    @Getter
    public final PautaRepository repository;

    private final VotoRepository votoRepository;
    private final MapperFacade mapper;

    public ResultadoOutputDto getResultado(Long id) {
        List<Voto> votos = votoRepository.findAllBySessaoPautaId(id);
        return ResultadoOutputDto.builder()
                .idPauta(id)
                .totalSim(votos.stream().filter(voto -> SimNaoEnum.SIM.equals(voto.getVoto())).count())
                .totalNao(votos.stream().filter(voto -> SimNaoEnum.NAO.equals(voto.getVoto())).count())
                .build();
    }

    public PaginaDto<Pauta> pesquisar(Pauta pauta, Pageable pageable) {
        return mapper.map(repository.findAll(Example.of(pauta), pageable), PaginaDto.class);
    }

    public Pauta insert(PautaInputDto pautaInputDto) {
        Pauta pauta = mapper.map(pautaInputDto, Pauta.class);
        pauta.setCadastro(LocalDateTime.now());
        return repository.save(pauta);
    }

    public Pauta update(Long id, PautaInputDto pautaInputDto) {
        Pauta pauta = repository.findById(id).orElseThrow();
        mapper.map(pautaInputDto, pauta);
        pauta.setAtualizacao(LocalDateTime.now());
        return repository.save(pauta);
    }

}
