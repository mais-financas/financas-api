package com.neuralnet.financasapi.api.controller;

import com.neuralnet.financasapi.api.mapper.GestorMapper;
import com.neuralnet.financasapi.api.model.auth.input.LoginInput;
import com.neuralnet.financasapi.api.model.gestor.GestorModel;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.service.AuthService;
import com.neuralnet.financasapi.domain.service.GestorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final GestorMapper gestorMapper;

    @PostMapping("/login")
    public GestorModel login(@RequestBody LoginInput loginInput) {
        Gestor gestor = authService.authenticate(loginInput.email(), loginInput.senha());
        return gestorMapper.toModel(gestor);
    }
}
