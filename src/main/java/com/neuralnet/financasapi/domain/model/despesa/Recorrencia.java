package com.neuralnet.financasapi.domain.model.despesa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "recorrencia_despesa")
public class Recorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recorrencia_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Frequencia frequencia;

    private int quantidade;

}
