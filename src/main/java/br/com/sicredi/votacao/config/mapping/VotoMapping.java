package br.com.sicredi.votacao.config.mapping;

import br.com.sicredi.votacao.domain.Voto;
import br.com.sicredi.votacao.dto.VotoInputDto;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class VotoMapping implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(VotoInputDto.class, Voto.class)
                .field("idAssociado", "associado.id")
                .byDefault()
                .register();
    }

}
