package br.com.sicredi.votacao.repository;

import br.com.sicredi.votacao.domain.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    //@Query("SELECT s FROM Sessao s JOIN s.pauta p WHERE p.id = :idPauta and s.fim < now()")
    Optional<Sessao> findByPautaId(Long idPauta);

}
