package com.neuralnet.financasapi.api.mapper;

import com.neuralnet.financasapi.api.model.gestor.GestorModel;
import com.neuralnet.financasapi.domain.model.Gestor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GestorMapper {

    public GestorModel toModel(Gestor gestor) {
        return new GestorModel(gestor.getId(), gestor.getNome(), gestor.getEmail());
    }

    public List<GestorModel> toModel(List<Gestor> gestores) {
        return gestores.stream().map(this::toModel).collect(Collectors.toList());
    }
}
