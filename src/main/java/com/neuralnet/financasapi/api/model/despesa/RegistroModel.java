package com.neuralnet.financasapi.api.model.despesa;

import java.math.BigDecimal;
import java.util.Date;

public record RegistroModel(Long id, BigDecimal valor, Date data) {
}
