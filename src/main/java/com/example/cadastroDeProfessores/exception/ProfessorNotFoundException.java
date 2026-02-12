package com.example.cadastroDeProfessores.exception;

public class ProfessorNotFoundException extends RuntimeException {
    public ProfessorNotFoundException(Long id) {
        super("Professor " + id + " não encontrado");
    }
}
