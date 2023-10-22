package com.neuralnet.financasapi.domain.model.despesa;

import com.neuralnet.financasapi.domain.model.Categoria;
import com.neuralnet.financasapi.domain.model.Gestor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    @PrimaryKeyJoinColumn
    private Recorrencia recorrencia;

    @Builder.Default
    @OneToMany(mappedBy = "despesa", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Registro> registros = new ArrayList<>();

    public Registro addRegistro(BigDecimal valor, Date data) {
        Registro registro = Registro.builder()
                .valor(valor)
                .data(data)
                .despesa(this)
                .build();

        this.getRegistros().add(registro);
        return registro;
    }

    public void removerRegistro(Long registroId) {
        registros.removeIf(registro -> Objects.equals(registro.getId(), registroId));
    }

}
