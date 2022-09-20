package br.com.sicredi.votacao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ASSOCIADO")
public class Associado {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_ASSOCIADO", sequenceName = "SEQ_ASSOCIADO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ASSOCIADO")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

}
