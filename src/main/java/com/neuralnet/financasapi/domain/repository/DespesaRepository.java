package com.neuralnet.financasapi.domain.repository;

import com.neuralnet.financasapi.domain.model.despesa.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    List<Despesa> findByGestorId(UUID gestorId);

}
