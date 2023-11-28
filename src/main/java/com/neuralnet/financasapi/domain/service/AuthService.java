package com.neuralnet.financasapi.domain.service;

import com.neuralnet.financasapi.domain.model.Gestor;
import com.neuralnet.financasapi.domain.repository.GestorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final GestorRepository gestorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return gestorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("Usuário com email %s não encontrado", email)));
    }

    public Gestor register(Gestor gestor) {
        if (gestorRepository.existsByEmail(gestor.getEmail())) {
            throw new IllegalStateException("Já existe um gestor com esse email");
        }
        return gestorRepository.save(gestor);
    }

}
