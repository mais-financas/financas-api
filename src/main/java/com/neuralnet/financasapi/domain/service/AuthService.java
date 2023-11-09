package com.neuralnet.financasapi.domain.service;

import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.repository.GestorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final GestorRepository gestorRepository;

    // TODO: Implementar autenticação corretamente
    public Gestor authenticate(String email, String senha) {
        return gestorRepository.findByEmailAndSenha(email, senha)
                .orElseThrow(() -> new IllegalStateException("Email ou senha incorretos"));
    }
}
