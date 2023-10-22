package com.neuralnet.financasapi.api.model.despesa;

import com.neuralnet.financasapi.domain.model.Categoria;

public record CategoriaResumoModel(Integer id, String nome) {

    public static CategoriaResumoModel fromEntity(Categoria categoria) {
        return new CategoriaResumoModel(categoria.getId(), categoria.getNome());
    }

}
