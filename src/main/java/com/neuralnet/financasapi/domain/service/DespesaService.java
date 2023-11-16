package com.neuralnet.financasapi.domain.service;

import com.neuralnet.financasapi.domain.model.Categoria;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import com.neuralnet.financasapi.domain.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;
    private final GestorService gestorService;
    private final CategoriaService categoriaService;

    public Despesa findById(Long despesaId) {
        return despesaRepository.findById(despesaId)
                .orElseThrow(() -> new IllegalStateException("Nenhuma despesa com id " + despesaId));
    }

    @Transactional
    public Despesa save(Despesa despesa) {
        Despesa despesaCompleta = configurarDespesaJpa(despesa);

        return despesaRepository.save(despesaCompleta);
    }

    @Transactional
    public List<Despesa> saveAll(List<Despesa> despesas) {
        List<Despesa> despesasCompletas = despesas.stream().map(this::configurarDespesaJpa).toList();

        return despesaRepository.saveAll(despesasCompletas);
    }

    @Transactional
    public void sincronizar(List<Despesa> despesas) {
        List<Despesa> despesasAtualizadas = despesas.stream().map(this::configurarDespesaJpa).toList();

        despesaRepository.saveAll(despesasAtualizadas);
    }

    private Despesa configurarDespesaJpa(Despesa despesa) {
        Gestor gestor = gestorService.findById(despesa.getGestor().getId());
        despesa.setGestor(gestor);

        Categoria categoria = categoriaService.findById(despesa.getCategoria().getId());
        despesa.setCategoria(categoria);

        despesa.getRegistros().forEach(registro -> registro.setDespesa(despesa));

        return despesa;
    }
}
