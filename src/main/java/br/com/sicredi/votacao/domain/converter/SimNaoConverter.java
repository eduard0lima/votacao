package br.com.sicredi.votacao.domain.converter;

import br.com.sicredi.votacao.domain.enumeration.SimNaoEnum;

import javax.persistence.AttributeConverter;

public class SimNaoConverter implements AttributeConverter<SimNaoEnum, String> {

    @Override
    public String convertToDatabaseColumn(SimNaoEnum situacao) {
        return situacao.name();
    }

    @Override
    public SimNaoEnum convertToEntityAttribute(String codidgo) {
        return SimNaoEnum.valueOf(codidgo);
    }

}
