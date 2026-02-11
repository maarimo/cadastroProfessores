package com.example.cadastroDeProfessores.controller;

import com.example.cadastroDeProfessores.dto.ProfessorCreateDTO;
import com.example.cadastroDeProfessores.dto.ProfessorDTO;
import com.example.cadastroDeProfessores.dto.ProfessorUpdateDTO;
import com.example.cadastroDeProfessores.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@AllArgsConstructor
public class ProfessorController {

    private ProfessorService professorService;

    //CREATE
    @PostMapping()
    public ProfessorDTO criar(@Valid @RequestBody ProfessorCreateDTO dto){
        return professorService.criar(dto);
    }

    //LISTAR
    @GetMapping
    public List<ProfessorDTO> buscarTodos(){
        return professorService.listar();
    }

    //BuscarPorId
    @GetMapping("/{id}")
    public ProfessorDTO buscarPorId(@PathVariable Long id){
        return professorService.buscarPorId(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ProfessorDTO atualizar(@PathVariable Long id,
                                  @RequestBody ProfessorUpdateDTO dto){
        return professorService.atualizar(id, dto);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        professorService.deletar(id);
    }
}
