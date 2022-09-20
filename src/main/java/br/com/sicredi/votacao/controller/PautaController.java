package br.com.sicredi.votacao.controller;

import br.com.sicredi.votacao.domain.Pauta;
import br.com.sicredi.votacao.dto.PaginaDto;
import br.com.sicredi.votacao.dto.PautaInputDto;
import br.com.sicredi.votacao.dto.ResultadoOutputDto;
import br.com.sicredi.votacao.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pautas")
public class PautaController {

    private final PautaService service;

    @GetMapping("/{id}")
    public Pauta getPauta(@PathVariable Long id) {
        return service.getRepository().findById(id).orElseThrow();
    }

    @GetMapping("/{id}/resultado")
    public ResultadoOutputDto getResultado(@PathVariable Long id) {
        return service.getResultado(id);
    }

    @GetMapping
    public PaginaDto<Pauta> getPautas(@ModelAttribute Pauta pauta,
                                      @PageableDefault(size = 50) Pageable pageable) {
        return service.pesquisar(pauta, pageable);
    }

    @PostMapping
    public Pauta insert(@RequestBody @Valid PautaInputDto pautaInputDto) {
        return service.insert(pautaInputDto);
    }

    @PutMapping("/{id}")
    public Pauta update(@PathVariable Long id, @RequestBody @Valid PautaInputDto pautaInputDto) {
        return service.update(id, pautaInputDto);
    }

}
