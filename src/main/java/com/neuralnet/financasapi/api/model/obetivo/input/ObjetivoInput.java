package com.neuralnet.financasapi.api.model.obetivo.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.model.Objetivo;

import java.math.BigDecimal;
import java.util.UUID;

public record ObjetivoInput(

        String descricao,

        BigDecimal valor,

        @JsonProperty("gestor_id")
        UUID gestorId
) {
        public Objetivo toEntity() {
                return Objetivo.builder()
                        .descricao(descricao)
                        .valor(valor)
                        .gestor(Gestor.builder().id(gestorId).build())
                        .build();
        }
}
