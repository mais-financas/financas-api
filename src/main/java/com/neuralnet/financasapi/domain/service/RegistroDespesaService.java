package com.neuralnet.financasapi.domain.service;

import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import com.neuralnet.financasapi.domain.model.despesa.Registro;
import com.neuralnet.financasapi.domain.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class RegistroDespesaService {

    private final DespesaService despesaService;
    private final DespesaRepository despesaRepository;

    public List<Registro> getRegistrosByDespesaId(Long despesaId) {
        return despesaService.findById(despesaId).getRegistros();
    }

    @Transactional
    public Registro addRegistro(Long despesaId, BigDecimal valor, Date data) {
        Despesa despesa = despesaService.findById(despesaId);
        Registro registro = despesa.addRegistro(valor, data);
        despesaRepository.save(despesa);
        return registro;
    }

    @Transactional
    public void removeRegistro(Long despesaId, Long registroId) {
        Despesa despesa = despesaService.findById(despesaId);

        despesa.removerRegistro(registroId);
        despesaRepository.save(despesa);
    }

    public void updateRegistro(Long despesaId, Registro registroAtualizado) {
        Despesa despesa = despesaService.findById(despesaId);

        despesa.getRegistros().stream()
                .filter(registro -> Objects.equals(registro.getId(), registroAtualizado.getId()))
                .findFirst()
                .ifPresent(registro -> {
                    registro.setValor(registroAtualizado.getValor());
                    registro.setData(registroAtualizado.getData());
                });

        despesaRepository.save(despesa);
    }

    public boolean existsById(Long despesaId, Long registroId) {
        Despesa despesa = despesaService.findById(despesaId);
        return despesa.getRegistros().stream()
                .anyMatch(registro -> registro.getId().equals(registroId));
    }
}
