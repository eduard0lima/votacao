package br.com.sicredi.votacao.controller;

import br.com.sicredi.votacao.domain.Associado;
import br.com.sicredi.votacao.domain.Pauta;
import br.com.sicredi.votacao.dto.AssociadoInputDto;
import br.com.sicredi.votacao.dto.PautaInputDto;
import br.com.sicredi.votacao.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/associados")
public class AssociadoController {

    private final AssociadoService service;

    @PostMapping({"/v1.0"})
    public Associado insert(@RequestBody @Valid AssociadoInputDto associadoInputDto) {
        return service.insert(associadoInputDto);
    }

}
