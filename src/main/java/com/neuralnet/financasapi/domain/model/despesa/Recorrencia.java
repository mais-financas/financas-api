package com.neuralnet.financasapi.domain.model.despesa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToOne
    @JoinColumn(name = "despesa_id")
    private Despesa despesa;

}
