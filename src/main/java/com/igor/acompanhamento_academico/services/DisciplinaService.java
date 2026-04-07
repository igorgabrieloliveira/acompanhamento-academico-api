package com.igor.acompanhamento_academico.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igor.acompanhamento_academico.dtos.disciplina.DisciplinaRequestDTO;
import com.igor.acompanhamento_academico.dtos.disciplina.DisciplinaResponseDTO;
import com.igor.acompanhamento_academico.entities.Disciplina;
import com.igor.acompanhamento_academico.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {
    
    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository){
        this.repository = repository;
    }

    public DisciplinaResponseDTO cadastrarDisciplina (DisciplinaRequestDTO dto){
        Disciplina newDisciplina = new Disciplina(dto.name(), dto.semestre(), dto.maximoFaltas(), dto.cargaHoraria());
        

        Disciplina save = repository.save(newDisciplina);
        return new DisciplinaResponseDTO(save);
    }

    public List<DisciplinaResponseDTO> listarTodos(){
        List<DisciplinaResponseDTO> listDTO = repository.findAll()
                                .stream()
                                .map(n -> new DisciplinaResponseDTO(n))
                                .toList();
        return listDTO;
    }
}
