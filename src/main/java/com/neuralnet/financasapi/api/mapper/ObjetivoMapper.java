package com.neuralnet.financasapi.api.mapper;

import com.neuralnet.financasapi.api.model.obetivo.ObjetivoModel;
import com.neuralnet.financasapi.domain.model.Objetivo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjetivoMapper {

    public ObjetivoModel toModel(Objetivo objetivo) {
        return new ObjetivoModel(objetivo.getId(), objetivo.getDescricao(), objetivo.getValor());
    }

    public List<ObjetivoModel> asModel(List<Objetivo> objetivos) {
        return objetivos.stream().map(this::toModel).toList();
    }

}
