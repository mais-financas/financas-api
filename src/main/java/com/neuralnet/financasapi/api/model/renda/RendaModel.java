package com.neuralnet.financasapi.api.model.renda;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public record RendaModel(
        Integer id,
        String descricao,
        BigDecimal valor,
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date data
) {
}
