package com.igor.acompanhamento_academico.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igor.acompanhamento_academico.entities.Disciplina;
import com.igor.acompanhamento_academico.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {
    
    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository){
        this.repository = repository;
    }

    public Disciplina cadastrarDisciplina (Disciplina disciplina){
        return repository.save(disciplina);
    }

    public List<Disciplina> listarTodos(){
        return repository.findAll();
    }
}
