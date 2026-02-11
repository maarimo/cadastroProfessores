package com.example.cadastroDeProfessores.service;

import com.example.cadastroDeProfessores.dto.ProfessorCreateDTO;
import com.example.cadastroDeProfessores.dto.ProfessorDTO;
import com.example.cadastroDeProfessores.dto.ProfessorUpdateDTO;
import com.example.cadastroDeProfessores.entity.ProfessorEntity;
import com.example.cadastroDeProfessores.exception.ProfessorNotFound;
import com.example.cadastroDeProfessores.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    private ProfessorDTO toDTO(ProfessorEntity professor){
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setEmail(professor.getEmail());

        return dto;
    }

    //CREATE
    public ProfessorDTO criar(ProfessorCreateDTO dto){
        ProfessorEntity professor = new ProfessorEntity();

        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());

        ProfessorEntity salvo = professorRepository.save(professor);
        return toDTO(salvo);
    }


    //LISTARALL
    public List<ProfessorDTO> listar(){
        return professorRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //LISTID
    public ProfessorDTO buscarPorId(Long id){
        ProfessorEntity professor = professorRepository.findById(id)
                .orElseThrow(()-> new ProfessorNotFound(id));

        return toDTO(professor);
    }

    //UPDATE
    public ProfessorDTO atualizar(Long id, ProfessorUpdateDTO dto){
        ProfessorEntity professor = professorRepository.findById(id)
                .orElseThrow(()-> new ProfessorNotFound(id));

        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());

        ProfessorEntity atualizado = professorRepository.save(professor);
        return toDTO(atualizado);
    }

    //DELETE
    public void deletar(Long id){
        ProfessorEntity professor = professorRepository.findById(id)
                .orElseThrow(()-> new ProfessorNotFound(id));

            professorRepository.delete(professor);
    }

}
