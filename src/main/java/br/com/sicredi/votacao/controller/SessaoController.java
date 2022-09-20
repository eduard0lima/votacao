package br.com.sicredi.votacao.controller;

import br.com.sicredi.votacao.domain.Pauta;
import br.com.sicredi.votacao.domain.Sessao;
import br.com.sicredi.votacao.dto.PaginaDto;
import br.com.sicredi.votacao.dto.ResultadoOutputDto;
import br.com.sicredi.votacao.dto.SessaoInputDto;
import br.com.sicredi.votacao.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sessoes")
public class SessaoController {

    private final SessaoService service;

    @GetMapping("/{id}")
    public Sessao getSessao(@PathVariable Long id) {
        return service.getRepository().findById(id).orElseThrow();
    }

    @GetMapping
    public PaginaDto<Sessao> getSessoes(@ModelAttribute Sessao sessao,
                                      @PageableDefault(size = 50) Pageable pageable) {
        return service.pesquisar(sessao, pageable);
    }

    @PostMapping
    public Sessao insert(@RequestBody @Valid SessaoInputDto sessaoInputDto) {
        return service.insert(sessaoInputDto);
    }

}
