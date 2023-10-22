package com.neuralnet.financasapi.api.model.despesa.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neuralnet.financasapi.domain.model.Categoria;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.model.despesa.Despesa;

import java.util.UUID;

public record DespesaInput(
        String nome,

        @JsonProperty("definir_lembrete")
        boolean definirLembrete,

        @JsonProperty("gestor_id")
        UUID gestorId,

        @JsonProperty("categoria_id")
        Integer categoriaId,

        RecorrenciaInput recorrencia,

        RegistroInput registro
) {

        public Despesa toEntity() {
                return Despesa.builder()
                        .nome(nome)
                        .definirLembrete(definirLembrete)
                        .gestor(Gestor.builder().id(gestorId).build())
                        .categoria(Categoria.builder().id(categoriaId).build())
                        .build();
        }

        public Despesa toEntity(Long despesaId) {
                Despesa despesa = this.toEntity();
                despesa.setId(despesaId);
                return despesa;
        }
}
