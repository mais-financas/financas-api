package com.neuralnet.financasapi.api.model.despesa.input;

import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import com.neuralnet.financasapi.domain.model.despesa.Frequencia;
import com.neuralnet.financasapi.domain.model.despesa.Recorrencia;

public record RecorrenciaInput(Frequencia frequencia, int quantidade) {

    public Recorrencia toEntity(Despesa despesa) {
        return Recorrencia.builder()
                .frequencia(frequencia)
                .quantidade(quantidade)
                .despesa(despesa)
                .build();
    }

}
