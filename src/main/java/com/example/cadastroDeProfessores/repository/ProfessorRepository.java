package com.example.cadastroDeProfessores.repository;

import com.example.cadastroDeProfessores.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}
