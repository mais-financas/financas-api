package com.neuralnet.financasapi.api.model.renda.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.model.Renda;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record RendaInput(

        String descricao,

        BigDecimal valor,

        Date data,

        @JsonProperty("gestor_id")
        UUID gestorId
) {
        public Renda toEntity() {
                return Renda.builder()
                        .descricao(descricao)
                        .valor(valor)
                        .data(data)
                        .gestor(Gestor.builder().id(gestorId).build())
                        .build();
        }
}
