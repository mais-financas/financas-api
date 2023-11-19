
package com.neuralnet.financasapi.api.controller;


import com.neuralnet.financasapi.api.mapper.ObjetivoMapper;
import com.neuralnet.financasapi.api.model.obetivo.ObjetivoModel;
import com.neuralnet.financasapi.api.model.obetivo.input.ObjetivoInput;
import com.neuralnet.financasapi.api.model.obetivo.input.ObjetivoSyncInput;
import com.neuralnet.financasapi.domain.model.Objetivo;
import com.neuralnet.financasapi.domain.repository.ObjetivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/objetivos")
public class ObjetivoController {

    private final ObjetivoMapper objetivoMapper;
    private final ObjetivoRepository objetivoRepository;


    @GetMapping
    public List<ObjetivoModel> listAllByGestor(@Param("gestorId") String gestorId) {
        return objetivoMapper.asModel(objetivoRepository.findByGestorId(UUID.fromString(gestorId)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ObjetivoModel> inserir(@RequestBody ObjetivoInput objetivoInput) {
        Objetivo objetivo = objetivoRepository.save(objetivoInput.toEntity());

        return ResponseEntity.ok(objetivoMapper.toModel(objetivo));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/setup")
    public ResponseEntity<List<ObjetivoModel>> inserirAll(@RequestBody List<ObjetivoInput> objetivosInput) {
        Stream<Objetivo> objetivoStream = objetivosInput.stream().map(ObjetivoInput::toEntity);

        List<Objetivo> objetivos = objetivoRepository.saveAll(objetivoStream.toList());

        return ResponseEntity.ok(objetivoMapper.asModel(objetivos));
    }

    @PatchMapping("/{objetivoId}")
    public ResponseEntity<ObjetivoModel> update(
            @PathVariable("objetivoId") Integer objetivoId,
            @RequestBody ObjetivoInput objetivoInput) {
        if (!objetivoRepository.existsById(objetivoId)) {
            return ResponseEntity.notFound().build();
        }
        Objetivo objetivo = objetivoInput.toEntity();
        objetivo.setId(objetivoId);

        objetivo = objetivoRepository.save(objetivo);

        return ResponseEntity.ok(objetivoMapper.toModel(objetivo));
    }

    @PostMapping("/sincronizar")
    public ResponseEntity<Void> sincronizar(@RequestBody List<ObjetivoSyncInput> objetivosInput) {
        List<Objetivo> objetivos = objetivosInput.stream().map(ObjetivoSyncInput::toEntity).toList();

        objetivoRepository.saveAll(objetivos);

        return ResponseEntity.noContent().build();
    }

}
