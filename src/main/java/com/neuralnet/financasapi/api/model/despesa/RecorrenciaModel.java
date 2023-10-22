package com.neuralnet.financasapi.api.model.despesa;

import com.neuralnet.financasapi.domain.model.despesa.Frequencia;
import com.neuralnet.financasapi.domain.model.despesa.Recorrencia;

public record RecorrenciaModel(Frequencia frequencia, int quantidade) {

    public static RecorrenciaModel fromEntity(Recorrencia recorrencia) {
        if (recorrencia == null) {
            return new RecorrenciaModel(Frequencia.NENHUMA, 0);
        }
        return new RecorrenciaModel(recorrencia.getFrequencia(), recorrencia.getQuantidade());
    }

}
