package com.neuralnet.financasapi.api.mapper;

import com.neuralnet.financasapi.api.model.despesa.CategoriaResumoModel;
import com.neuralnet.financasapi.api.model.despesa.DespesaModel;
import com.neuralnet.financasapi.api.model.despesa.RecorrenciaModel;
import com.neuralnet.financasapi.api.model.gestor.GestorResumoModel;
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
                GestorResumoModel.fromEntity(despesa.getGestor()),
                CategoriaResumoModel.fromEntity(despesa.getCategoria()),
                RecorrenciaModel.fromEntity(despesa.getRecorrencia())
        );
    }

    public List<DespesaModel> toModel(List<Despesa> despesas) {
        return despesas.stream().map(this::toModel).collect(Collectors.toList());
    }
}
