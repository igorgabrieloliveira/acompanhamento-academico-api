package com.igor.acompanhamento_academico.services;

import org.springframework.stereotype.Service;

import com.igor.acompanhamento_academico.dtos.aluno.AlunoRequestDTO;
import com.igor.acompanhamento_academico.dtos.aluno.AlunoResponseDTO;
import com.igor.acompanhamento_academico.entities.Aluno;
import com.igor.acompanhamento_academico.repositories.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository repository;
    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }

    public AlunoResponseDTO cadastrarAluno(AlunoRequestDTO dto){
        Aluno newAluno = new Aluno(dto.name(), dto.email(), dto.password());
        Aluno save = repository.save(newAluno);
        return new AlunoResponseDTO(save);
    }



}
