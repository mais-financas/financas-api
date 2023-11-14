package com.neuralnet.financasapi.api.controller;


import com.neuralnet.financasapi.api.mapper.RendaMapper;
import com.neuralnet.financasapi.api.model.renda.RendaModel;
import com.neuralnet.financasapi.api.model.renda.input.RendaInput;
import com.neuralnet.financasapi.domain.model.Renda;
import com.neuralnet.financasapi.domain.repository.RendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/rendas")
public class RendaController {

    private final RendaMapper rendaMapper;
    private final RendaRepository rendaRepository;


    @GetMapping
    public List<RendaModel> listAllByGestor(@Param("gestorId") String gestorId) {
        return rendaMapper.asModel(rendaRepository.findByGestorId(UUID.fromString(gestorId)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<RendaModel> inserir(@RequestBody RendaInput rendaInput) {
        Renda renda = rendaRepository.save(rendaInput.toEntity());

        return ResponseEntity.ok(rendaMapper.toModel(renda));
    }

}