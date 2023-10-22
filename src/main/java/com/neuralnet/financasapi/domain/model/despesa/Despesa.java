package com.neuralnet.financasapi.domain.model.despesa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.neuralnet.financasapi.domain.model.Categoria;
import com.neuralnet.financasapi.domain.model.Gestor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "despesa_id")
    private Long id;

    @Column(name = "nome_despesa")
    private String nome;

    @Column(name = "definir_lembrete")
    private boolean definirLembrete;

    @ManyToOne
    @JoinColumn(name = "gestor_id", nullable = false)
    private Gestor gestor;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @OneToOne(mappedBy = "despesa", cascade = CascadeType.ALL)
    @JoinColumn(name = "recorrencia_id")
    private Recorrencia recorrencia;

    @Builder.Default
    @OneToMany(mappedBy = "despesa", cascade = CascadeType.ALL)
    List<Registro> registros = new ArrayList<>();

}
