package br.com.sicredi.votacao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "SESSAO")
public class Sessao {

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "SEQ_SESSAO", sequenceName = "SEQ_SESSAO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SESSAO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PAUTA", nullable = false)
    private Pauta pauta;

    @Column(name = "FIM", nullable = false)
    private LocalDateTime fim;

    public Boolean isAberta() {
        if (LocalDateTime.now().isBefore(this.fim)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}
