package br.com.sicredi.votacao.domain;

import br.com.sicredi.votacao.domain.converter.SimNaoConverter;
import br.com.sicredi.votacao.domain.enumeration.SimNaoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "VOTO")
public class Voto {

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "SEQ_VOTO", sequenceName = "SEQ_VOTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VOTO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_SESSAO", nullable = false)
    private Sessao sessao;

    @ManyToOne
    @JoinColumn(name = "ID_ASSOCIADO", nullable = false)
    private Associado associado;

    @Column(name = "VOTO")
    @Convert(converter = SimNaoConverter.class)
    private SimNaoEnum voto;

}
