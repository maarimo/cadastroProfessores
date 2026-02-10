package com.example.cadastroDeProfessores.repository;

import com.example.cadastroDeProfessores.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
    Optional<ProfessorEntity> findById(Long along);
}
