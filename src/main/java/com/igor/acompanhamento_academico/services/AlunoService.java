package com.igor.acompanhamento_academico.services;

import org.springframework.stereotype.Service;

import com.igor.acompanhamento_academico.entities.Aluno;
import com.igor.acompanhamento_academico.repositories.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository repository;
    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }

    public Aluno cadastrarAluno(Aluno aluno){
        return repository.save(aluno);
    }



}
