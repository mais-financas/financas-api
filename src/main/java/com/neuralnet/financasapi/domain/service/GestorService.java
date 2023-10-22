package com.neuralnet.financasapi.domain.service;

import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.repository.GestorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class GestorService {

    private final GestorRepository gestorRepository;

    public Gestor findById(UUID gestorId) {
        return gestorRepository.findById(gestorId)
                .orElseThrow(() -> new IllegalStateException("Gestor não encontrado"));
    }

    public Gestor save(Gestor gestor) {
        return gestorRepository.save(gestor);
    }

    public void deleteById(UUID gestorId) {
        gestorRepository.deleteById(gestorId);
    }
}
