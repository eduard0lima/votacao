package br.com.sicredi.votacao.service;

import br.com.sicredi.votacao.config.exceptions.CustomRestException;
import br.com.sicredi.votacao.config.exceptions.ExceptionEnum;
import br.com.sicredi.votacao.domain.Sessao;
import br.com.sicredi.votacao.domain.Voto;
import br.com.sicredi.votacao.dto.PaginaDto;
import br.com.sicredi.votacao.dto.ResultadoOutputDto;
import br.com.sicredi.votacao.dto.SessaoInputDto;
import br.com.sicredi.votacao.repository.SessaoRepository;
import br.com.sicredi.votacao.repository.VotoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SessaoService {

    @Getter
    public final SessaoRepository repository;

    private final MapperFacade mapper;

    public PaginaDto<Sessao> pesquisar(Sessao sessao, Pageable pageable) {
        return mapper.map(repository.findAll(Example.of(sessao), pageable), PaginaDto.class);
    }

    public Sessao insert(SessaoInputDto sessaoInputDto) {
        validarSessao(sessaoInputDto);
        Sessao sessao = mapper.map(sessaoInputDto, Sessao.class);
        if (sessao.getFim() == null) {
            sessao.setFim(LocalDateTime.now().plusMinutes(1));
        }
        return repository.save(sessao);
    }

    private void validarSessao(SessaoInputDto sessaoInputDto) {
        Optional<Sessao> sessaoOptional = repository.findByPautaId(sessaoInputDto.getIdPauta());
        if (sessaoOptional.isPresent()) {
            if (sessaoOptional.get().isAberta()) {
                throw new CustomRestException(ExceptionEnum.VOTACAO_003, sessaoInputDto.getIdPauta().toString());
            }
        }
    }

}
