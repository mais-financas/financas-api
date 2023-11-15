package com.neuralnet.financasapi.api.model.renda.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.model.Renda;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record RendaSyncInput(

        @JsonProperty("id")
        Integer id,

        @JsonProperty("descricao")
        String descricao,

        @JsonProperty("valor")
        BigDecimal valor,

        @JsonProperty("data")
        Date data,

        @JsonProperty("gestor_id")
        UUID gestorId
) {
        public Renda toEntity() {
                return Renda.builder()
                        .id(id)
                        .descricao(descricao)
                        .valor(valor)
                        .data(data)
                        .gestor(Gestor.builder().id(gestorId).build())
                        .build();
        }
}
