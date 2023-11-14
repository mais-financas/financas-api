package com.neuralnet.financasapi.api.mapper;

import com.neuralnet.financasapi.api.model.renda.RendaModel;
import com.neuralnet.financasapi.domain.model.Renda;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RendaMapper {

    public RendaModel toModel(Renda renda) {
        return new RendaModel(renda.getId(), renda.getDescricao(), renda.getValor(), renda.getData());
    }

    public List<RendaModel> asModel(List<Renda> rendas) {
        return rendas.stream().map(this::toModel).collect(Collectors.toList());
    }

}
