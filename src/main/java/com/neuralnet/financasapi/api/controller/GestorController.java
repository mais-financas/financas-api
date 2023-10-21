package com.neuralnet.financasapi.api.controller;

import com.neuralnet.financasapi.api.mapper.GestorMapper;
import com.neuralnet.financasapi.api.model.gestor.GestorModel;
import com.neuralnet.financasapi.api.model.gestor.input.GestorInput;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.repository.GestorRepository;
import com.neuralnet.financasapi.domain.service.GestorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/gestores")
public class GestorController {

    private final GestorService gestorService;
    private final GestorRepository gestorRepository;
    private final GestorMapper gestorMapper;

    @GetMapping
    public List<GestorModel> listAll() {
        return gestorMapper.toModel(gestorRepository.findAll());
    }

    @GetMapping("/{gestorId}")
    public ResponseEntity<GestorModel> findById(@PathVariable("gestorId") UUID gestorId) {
        return gestorRepository.findById(gestorId)
                .map(gestor -> ResponseEntity.ok(gestorMapper.toModel(gestor)))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<GestorModel> save(@RequestBody GestorInput gestorInput) {
        Gestor gestor = gestorService.save(gestorInput.toEntity());

        return ResponseEntity.ok(gestorMapper.toModel(gestor));
    }

    @PatchMapping("/{gestorId}")
    public ResponseEntity<GestorModel> update(@PathVariable("gestorId") UUID gestorId, @RequestBody GestorInput gestorInput) {
        if (!gestorRepository.existsById(gestorId)) {
            return ResponseEntity.notFound().build();
        }

        Gestor gestor = gestorService.save(gestorInput.toEntity(gestorId));
        return ResponseEntity.ok(gestorMapper.toModel(gestor));
    }

    @DeleteMapping("/{gestorId}")
    public ResponseEntity<Void> deleteById(@PathVariable("gestorId") UUID gestorId) {
        if (!gestorRepository.existsById(gestorId)) {
            return ResponseEntity.notFound().build();
        }

        gestorService.deleteById(gestorId);

        return ResponseEntity.noContent().build();
    }

}
