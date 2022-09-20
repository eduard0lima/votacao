package br.com.sicredi.votacao.controller;

import br.com.sicredi.votacao.domain.Voto;
import br.com.sicredi.votacao.dto.VotoInputDto;
import br.com.sicredi.votacao.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/votos")
public class VotoController {

    private final VotoService service;

    @PostMapping
    public Voto insert(@RequestBody @Valid VotoInputDto votoInputDto) {
        return service.insert(votoInputDto);
    }

}
