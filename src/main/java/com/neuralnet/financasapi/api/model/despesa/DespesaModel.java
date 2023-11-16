package com.neuralnet.financasapi.api.model.despesa;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public record DespesaModel(
        @JsonProperty("id")
        Long id,

        @JsonProperty("nome")
        String nome,

        @JsonProperty("definir_lembrete")
        boolean definirLembrete,

        @JsonProperty("gestor_id")
        UUID gestorId,

        @JsonProperty("categoria_id")
        Integer categoriaId,

        RecorrenciaModel recorrencia,

        List<RegistroModel> registros
) {
}
