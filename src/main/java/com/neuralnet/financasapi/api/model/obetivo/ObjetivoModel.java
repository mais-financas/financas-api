package com.neuralnet.financasapi.api.model.obetivo;

import java.math.BigDecimal;

public record ObjetivoModel(
        Integer id,
        String descricao,
        BigDecimal valor
) {
}
