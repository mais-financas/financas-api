package com.neuralnet.financasapi.api.model.gestor.input;

import com.neuralnet.financasapi.domain.model.Gestor;

import java.util.UUID;

public record GestorInput(String nome, String email, String senha) {

    public Gestor toEntity() {
        return Gestor.builder()
                .nome(nome)
                .email(email)
                .senha(senha)
                .build();
    }

    public Gestor toEntity(UUID gestorId) {
        return new Gestor(gestorId, nome, email, senha);
    }
}
