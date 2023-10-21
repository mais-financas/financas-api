package com.neuralnet.financasapi.api.controller;

import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.repository.GestorRepository;
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

    private final GestorRepository gestorRepository;

    @GetMapping
    public List<Gestor> listAll() {
        return gestorRepository.findAll();
    }

    @GetMapping("/{gestorId}")
    public ResponseEntity<Gestor> findById(@PathVariable("gestorId") UUID gestorId) {
        return gestorRepository.findById(gestorId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Gestor> save(@RequestBody Gestor gestorInput) {
        return ResponseEntity.ok(gestorRepository.save(gestorInput));
    }

    @PatchMapping("/{gestorId}")
    public ResponseEntity<Gestor> update(@PathVariable("gestorId") UUID gestorId, @RequestBody Gestor gestor) {
        if (!gestorRepository.existsById(gestorId)) {
            return ResponseEntity.notFound().build();
        }

        gestor.setId(gestorId);
        return ResponseEntity.ok(gestorRepository.save(gestor));
    }

    @DeleteMapping("/{gestorId}")
    public ResponseEntity<Gestor> deleteById(@PathVariable("gestorId") UUID gestorId) {
        if (!gestorRepository.existsById(gestorId)) {
            return ResponseEntity.notFound().build();
        }

        gestorRepository.deleteById(gestorId);

        return ResponseEntity.noContent().build();
    }

}
