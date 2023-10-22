package com.neuralnet.financasapi.api.controller;

import com.neuralnet.financasapi.api.mapper.RegistroMapper;
import com.neuralnet.financasapi.api.model.despesa.RegistroModel;
import com.neuralnet.financasapi.api.model.despesa.input.RegistroInput;
import com.neuralnet.financasapi.domain.model.despesa.Registro;
import com.neuralnet.financasapi.domain.service.RegistroDespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/despesas/{despesaId}/registros")
public class RegistroController {

    private final RegistroMapper registroMapper;
    private final RegistroDespesaService registroDespesaService;

    @GetMapping
    public List<RegistroModel> findAllByDespesa(@PathVariable("despesaId") Long despesaId) {
        List<Registro> registros = registroDespesaService.getRegistrosByDespesaId(despesaId);
        return registroMapper.toModel(registros);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<RegistroModel> save(
            @PathVariable("despesaId") Long despesaId,
            @RequestBody RegistroInput registroInput
    ) {
        Registro registro = registroDespesaService.addRegistro(despesaId, registroInput.valor(), registroInput.data());

        return ResponseEntity.ok(registroMapper.toModel(registro));
    }

    @PatchMapping("/{registroId}")
    public ResponseEntity<RegistroModel> update(
            @PathVariable("despesaId") Long despesaId,
            @PathVariable("registroId") Long registroId,
            @RequestBody RegistroInput registroInput
    ) {
        if (!registroDespesaService.existsById(despesaId, registroId)) {
            return ResponseEntity.notFound().build();
        }

        Registro registro = Registro.builder()
                .id(registroId)
                .data(registroInput.data())
                .valor(registroInput.valor())
                .build();

        registroDespesaService.updateRegistro(despesaId, registro);

        return ResponseEntity.ok(registroMapper.toModel(registro));
    }

    @DeleteMapping("/{registroId}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("despesaId") Long despesaId,
            @PathVariable("registroId") Long registroId
    ) {
        if (!registroDespesaService.existsById(despesaId, registroId)) {
            return ResponseEntity.notFound().build();
        }

        registroDespesaService.removeRegistro(despesaId, registroId);

        return ResponseEntity.noContent().build();
    }

}
