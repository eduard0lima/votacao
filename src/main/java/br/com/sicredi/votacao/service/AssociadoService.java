package br.com.sicredi.votacao.service;

import br.com.sicredi.votacao.domain.Associado;
import br.com.sicredi.votacao.dto.AssociadoInputDto;
import br.com.sicredi.votacao.dto.PaginaDto;
import br.com.sicredi.votacao.repository.AssociadoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssociadoService {

    @Getter
    public final AssociadoRepository repository;
    private final MapperFacade mapper;

    public PaginaDto<Associado> pesquisar(Associado associado, Pageable pageable) {
        return mapper.map(repository.findAll(Example.of(associado), pageable), PaginaDto.class);
    }

    public Associado insert(AssociadoInputDto associadoInputDto) {
        Associado associado = mapper.map(associadoInputDto, Associado.class);
        return repository.save(associado);
    }

}
