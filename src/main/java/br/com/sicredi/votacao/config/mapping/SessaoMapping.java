package br.com.sicredi.votacao.config.mapping;

import br.com.sicredi.votacao.domain.Sessao;
import br.com.sicredi.votacao.dto.SessaoInputDto;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class SessaoMapping implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(SessaoInputDto.class, Sessao.class)
                .field("idPauta", "pauta.id")
                .byDefault()
                .register();
    }

}
