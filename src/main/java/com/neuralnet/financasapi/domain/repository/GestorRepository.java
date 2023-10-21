package com.neuralnet.financasapi.domain.repository;

import com.neuralnet.financasapi.domain.model.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, UUID> {
}
