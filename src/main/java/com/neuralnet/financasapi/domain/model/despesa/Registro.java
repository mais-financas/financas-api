package com.neuralnet.financasapi.domain.model.despesa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name = "registro_despesa")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_despesa_id")
    private Long id;

    private BigDecimal valor;

    private Date data;

    @JsonIgnore // TODO: Utilizar DTOs para respostas da API
    @ManyToOne
    @JoinColumn(name = "despesa_id")
    private Despesa despesa;

}
