package com.neuralnet.financasapi.domain.model.despesa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neuralnet.financasapi.domain.model.Categoria;
import com.neuralnet.financasapi.domain.model.Gestor;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    // TODO: Cadastrar despesa com recorrencia
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "despesa_id")
    private Recorrencia recorrencia;

    // TODO: Utilizar DTOs para respostas da API
    @OneToMany(mappedBy = "despesa", cascade = CascadeType.ALL)
    List<Registro> registros = new ArrayList<>();

}
