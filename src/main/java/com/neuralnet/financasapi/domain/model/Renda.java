package com.neuralnet.financasapi.domain.model;


import com.neuralnet.financasapi.domain.model.despesa.Recorrencia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "renda")
public class Renda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "renda_id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "gestor_id", nullable = false)
    private Gestor gestor;

}