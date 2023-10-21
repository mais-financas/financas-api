package com.neuralnet.financasapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "gestor")
public class Gestor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "gestor_id")
    private UUID id;

    private String nome;

    @Column(unique = true)
    private String email;

    //TODO: Proteger senha
    private String senha;

}
