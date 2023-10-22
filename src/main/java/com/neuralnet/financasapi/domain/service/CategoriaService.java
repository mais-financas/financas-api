package com.neuralnet.financasapi.domain.service;

import com.neuralnet.financasapi.domain.model.Categoria;
import com.neuralnet.financasapi.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria findById(Integer categoriaId) {
        return categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalStateException("Não existe categoria com id " + categoriaId));
    }

}
