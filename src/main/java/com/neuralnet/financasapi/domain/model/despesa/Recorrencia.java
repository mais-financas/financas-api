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
    @Column(name = "despesa_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Frequencia frequencia;

    private int quantidade;

    @OneToOne
    @MapsId
    @JoinColumn(name = "despesa_id")
    private Despesa despesa;

}
