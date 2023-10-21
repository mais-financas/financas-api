package com.neuralnet.financasapi.api.controller;

import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import com.neuralnet.financasapi.domain.repository.DespesaRepository;
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

    @GetMapping
    public List<Despesa> listAllByGestor(@Param("gestorId") String gestorId) {
        return despesaRepository.findByGestorId(UUID.fromString(gestorId));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Despesa> save(@RequestBody Despesa despesa) {
        return ResponseEntity.ok(despesaRepository.save(despesa));
    }

    @GetMapping("/{despesaId}")
    public ResponseEntity<Despesa> findById(@PathVariable("despesaId") Long despesaId) {
        return despesaRepository.findById(despesaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{despesaId}")
    public ResponseEntity<Despesa> update(@PathVariable("despesaId") Long despesaId, @RequestBody Despesa despesa) {
        if (!despesaRepository.existsById(despesaId)) {
            return ResponseEntity.notFound().build();
        }

        despesa.setId(despesaId);
        return ResponseEntity.ok(despesaRepository.save(despesa));
    }

    @DeleteMapping("/{despesaId}")
    public ResponseEntity<Despesa> deleteById(@PathVariable("despesaId") Long despesaId) {
        if (!despesaRepository.existsById(despesaId)) {
            return ResponseEntity.notFound().build();
        }

        despesaRepository.deleteById(despesaId);

        return ResponseEntity.noContent().build();
    }

}
