package com.neuralnet.financasapi.api.model.obetivo.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.model.Objetivo;

import java.math.BigDecimal;
import java.util.UUID;

public record ObjetivoSyncInput(

        @JsonProperty("id")
        Integer id,

        @JsonProperty("descricao")
        String descricao,

        @JsonProperty("valor")
        BigDecimal valor,

        @JsonProperty("gestor_id")
        UUID gestorId
) {
        public Objetivo toEntity() {
                return Objetivo.builder()
                        .id(id)
                        .descricao(descricao)
                        .valor(valor)
                        .gestor(Gestor.builder().id(gestorId).build())
                        .build();
        }
}
