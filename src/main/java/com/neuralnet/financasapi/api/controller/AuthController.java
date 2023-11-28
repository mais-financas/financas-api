package com.neuralnet.financasapi.api.controller;

import com.neuralnet.financasapi.api.mapper.GestorMapper;
import com.neuralnet.financasapi.api.model.auth.LoginResponse;
import com.neuralnet.financasapi.api.model.auth.input.LoginInput;
import com.neuralnet.financasapi.api.model.gestor.GestorModel;
import com.neuralnet.financasapi.api.model.gestor.input.GestorInput;
import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.security.JwtService;
import com.neuralnet.financasapi.domain.service.AuthService;
import com.neuralnet.financasapi.domain.service.GestorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final GestorMapper gestorMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginInput loginInput) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginInput.email(), loginInput.senha());
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = jwtService.generateToken((Gestor) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registrar")
    public ResponseEntity<GestorModel> save(@RequestBody GestorInput gestorInput) {
        Gestor gestor = authService.register(Gestor.builder()
                .nome(gestorInput.nome())
                .email(gestorInput.email())
                .senha(passwordEncoder.encode(gestorInput.senha()))
                .build());

        return ResponseEntity.ok(gestorMapper.toModel(gestor));
    }

}
