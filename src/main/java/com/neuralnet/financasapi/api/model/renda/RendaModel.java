package com.neuralnet.financasapi.api.model.renda;

import java.math.BigDecimal;
import java.util.Date;

public record RendaModel(Integer id, String descricao, BigDecimal valor, Date data) {
}
