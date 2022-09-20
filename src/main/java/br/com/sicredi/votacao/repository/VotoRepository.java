package br.com.sicredi.votacao.repository;

import br.com.sicredi.votacao.domain.Associado;
import br.com.sicredi.votacao.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotoRepository extends JpaRepository<Voto, Long> {

    List<Voto> findAllBySessaoPautaId(Long idPauta);

    Boolean existsBySessaoPautaIdAndAssociadoId(Long idPauta, Long idAssociado);

}
