package com.neuralnet.financasapi.domain.repository;

import com.neuralnet.financasapi.domain.model.Renda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RendaRepository extends JpaRepository<Renda, Integer> {

    List<Renda> findByGestorId(UUID uuid);

}
