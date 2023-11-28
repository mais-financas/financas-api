package com.neuralnet.financasapi.api.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record LoginResponse(String token, @JsonProperty("gestor_id") UUID gestorId) {
}
