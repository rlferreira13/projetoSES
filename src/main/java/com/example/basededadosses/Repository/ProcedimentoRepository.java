package com.example.basededadosses.Repository;

import com.example.basededadosses.Model.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface ProcedimentoRepository extends JpaRepository<Procedimento, UUID> {
    Procedimento findByDescricao (Procedimento descricao);

}