package br.com.sicredi.votacao.repository;

import br.com.sicredi.votacao.domain.Associado;
import br.com.sicredi.votacao.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

}
