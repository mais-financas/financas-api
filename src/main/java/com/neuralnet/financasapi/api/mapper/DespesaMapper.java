package com.neuralnet.financasapi.api.mapper;

import com.neuralnet.financasapi.api.model.despesa.DespesaModel;
import com.neuralnet.financasapi.api.model.despesa.RecorrenciaModel;
import com.neuralnet.financasapi.api.model.despesa.RegistroModel;
import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DespesaMapper {

    public DespesaModel toModel(Despesa despesa) {
        return new DespesaModel(
                despesa.getId(),
                despesa.getNome(),
                despesa.isDefinirLembrete(),
                despesa.getGestor().getId(),
                despesa.getCategoria().getId(),
                RecorrenciaModel.fromEntity(despesa.getRecorrencia()),
                RegistroModel.registrosFromEntity(despesa.getRegistros())
        );
    }

    public List<DespesaModel> toModel(List<Despesa> despesas) {
        return despesas.stream().map(this::toModel).collect(Collectors.toList());
    }
}
