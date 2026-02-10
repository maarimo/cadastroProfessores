package com.example.cadastroDeProfessores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ProfessorDTO {

    private Long id;
    private String nome;
    private String email;
}
