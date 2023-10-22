package com.neuralnet.financasapi.domain.service;

import com.neuralnet.financasapi.domain.model.Categoria;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import com.neuralnet.financasapi.domain.repository.CategoriaRepository;
import com.neuralnet.financasapi.domain.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;
    private final GestorService gestorService;
    private final CategoriaService categoriaService;

    @Transactional
    public Despesa save(Despesa despesa) {
        Gestor gestor = gestorService.findById(despesa.getGestor().getId());
        despesa.setGestor(gestor);

        Categoria categoria = categoriaService.findById(despesa.getCategoria().getId());
        despesa.setCategoria(categoria);

        despesa.getRegistros().forEach(registro -> registro.setDespesa(despesa));

        despesaRepository.save(despesa);

        return despesa;
    }

}
