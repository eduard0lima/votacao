package br.com.sicredi.votacao.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "PAUTA")
public class Pauta {

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "SEQ_PAUTA", sequenceName = "SEQ_PAUTA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAUTA")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "DESCRICAO", length = 300)
    private String descricao;

    @Column(name = "CADASTRO", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime cadastro;

    @Column(name = "ATUALIZACAO")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime atualizacao;

}
