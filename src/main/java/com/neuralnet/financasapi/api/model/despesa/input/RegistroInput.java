package com.neuralnet.financasapi.api.model.despesa.input;

import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import com.neuralnet.financasapi.domain.model.despesa.Registro;

import java.math.BigDecimal;
import java.util.Date;

public record RegistroInput(BigDecimal valor, Date data) {

    public Registro toEntity(Despesa despesa) {
        return Registro.builder()
                .valor(valor)
                .data(data)
                .despesa(despesa)
                .build();
    }
}
