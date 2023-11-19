package com.neuralnet.financasapi.domain.repository;

import com.neuralnet.financasapi.domain.model.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {

    List<Objetivo> findByGestorId(UUID uuid);

}
