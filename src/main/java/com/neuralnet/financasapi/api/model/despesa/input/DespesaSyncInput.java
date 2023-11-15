package com.neuralnet.financasapi.api.model.despesa.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neuralnet.financasapi.domain.model.Categoria;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import com.neuralnet.financasapi.domain.model.despesa.Recorrencia;
import com.neuralnet.financasapi.domain.model.despesa.Registro;

import java.util.List;
import java.util.UUID;

public record DespesaSyncInput(

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

        Recorrencia recorrencia,

        List<Registro> registros
) {
    public Despesa toEntity() {
        return Despesa.builder()
                .id(id)
                .nome(nome)
                .definirLembrete(definirLembrete)
                .gestor(Gestor.builder().id(gestorId).build())
                .categoria(Categoria.builder().id(categoriaId).build())
                .recorrencia(new Recorrencia(id, recorrencia.getFrequencia(), recorrencia.getQuantidade(), null))
                .registros(registros).build();
    }

}
