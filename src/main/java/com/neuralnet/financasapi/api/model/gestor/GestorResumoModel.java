package com.neuralnet.financasapi.api.model.gestor;

import com.neuralnet.financasapi.domain.model.Gestor;

import java.util.UUID;

public record GestorResumoModel(UUID id, String nome) {

    public static GestorResumoModel fromEntity(Gestor gestor) {
        return new GestorResumoModel(gestor.getId(), gestor.getNome());
    }
}
