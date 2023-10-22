package com.neuralnet.financasapi.api.controller;

import com.neuralnet.financasapi.api.mapper.DespesaMapper;
import com.neuralnet.financasapi.api.model.despesa.DespesaModel;
import com.neuralnet.financasapi.api.model.despesa.input.DespesaInput;
import com.neuralnet.financasapi.api.model.despesa.input.RegistroInput;
import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import com.neuralnet.financasapi.domain.model.despesa.Recorrencia;
import com.neuralnet.financasapi.domain.model.despesa.Registro;
import com.neuralnet.financasapi.domain.repository.DespesaRepository;
import com.neuralnet.financasapi.domain.service.DespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

    private final DespesaRepository despesaRepository;
    private final DespesaService despesaService;
    private final DespesaMapper despesaMapper;

    @GetMapping
    public List<DespesaModel> listAllByGestor(@Param("gestorId") String gestorId) {
        return despesaMapper.toModel(despesaRepository.findByGestorId(UUID.fromString(gestorId)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<DespesaModel> save(@RequestBody DespesaInput despesaInput) {
        Despesa despesa = despesaInput.toEntity();

        if (despesaInput.recorrencia() != null) {
            Recorrencia recorrencia = despesaInput.recorrencia().toEntity(despesa);
            despesa.setRecorrencia(recorrencia);
        }

        Registro registro = despesaInput.registro().toEntity(despesa);
        despesa.setRegistros(List.of(registro));
        despesaService.save(despesa);

        return ResponseEntity.ok(despesaMapper.toModel(despesa));
    }

    @GetMapping("/{despesaId}")
    public ResponseEntity<DespesaModel> findById(@PathVariable("despesaId") Long despesaId) {
        return despesaRepository.findById(despesaId)
                .map(despesa -> ResponseEntity.ok(despesaMapper.toModel(despesa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{despesaId}")
    public ResponseEntity<DespesaModel> update(
            @PathVariable("despesaId") Long despesaId,
            @RequestBody DespesaInput despesaInput) {
        if (!despesaRepository.existsById(despesaId)) {
            return ResponseEntity.notFound().build();
        }

        Despesa despesa = despesaService.save(despesaInput.toEntity(despesaId));

        return ResponseEntity.ok(despesaMapper.toModel(despesa));
    }

    @DeleteMapping("/{despesaId}")
    public ResponseEntity<Void> deleteById(@PathVariable("despesaId") Long despesaId) {
        if (!despesaRepository.existsById(despesaId)) {
            return ResponseEntity.notFound().build();
        }

        despesaRepository.deleteById(despesaId);

        return ResponseEntity.noContent().build();
    }

}
