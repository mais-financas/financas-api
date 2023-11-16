package com.neuralnet.financasapi.api.model.despesa;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neuralnet.financasapi.domain.model.despesa.Registro;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record RegistroModel(
        Long id,
        BigDecimal valor,
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date data
) {

    public static List<RegistroModel> registrosFromEntity(List<Registro> registros) {
        return registros.stream()
                .map(registro -> new RegistroModel(registro.getId(), registro.getValor(), registro.getData()))
                .toList();
    }
}
