package com.neuralnet.financasapi.api.mapper;

import com.neuralnet.financasapi.api.model.despesa.RegistroModel;
import com.neuralnet.financasapi.domain.model.despesa.Registro;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegistroMapper {

    public RegistroModel toModel(Registro registro) {
        return new RegistroModel(registro.getId(), registro.getValor(), registro.getData());
    }

    public List<RegistroModel> toModel(List<Registro> registros) {
        return registros.stream().map(this::toModel).collect(Collectors.toList());
    }
}