package com.example.cadastroDeProfessores.exception;

public class ProfessorNotFound extends RuntimeException {
    public ProfessorNotFound(Long id) {
        super("Professor " + id + " não encontrado");
    }
}
