package com.neuralnet.financasapi.api.model.despesa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neuralnet.financasapi.api.model.gestor.GestorResumoModel;

public record DespesaModel(
        @JsonProperty("id")
        Long id,

        @JsonProperty("nome")
        String nome,

        @JsonProperty("definir_lembrete")
        boolean definirLembrete,

        GestorResumoModel gestor,

        CategoriaResumoModel categoria,

        RecorrenciaModel recorrencia
) {
}
