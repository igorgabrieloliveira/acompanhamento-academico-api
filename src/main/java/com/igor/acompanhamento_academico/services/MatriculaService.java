package com.igor.acompanhamento_academico.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igor.acompanhamento_academico.entities.Matricula;
import com.igor.acompanhamento_academico.repositories.MatriculaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository repository;
    public MatriculaService(MatriculaRepository repository){
        this.repository = repository;
    }

    public Matricula cadastrarMatricula(Matricula matricula){
        return repository.save(matricula);
    }

    public List<Matricula> listarTodas(){
        return repository.findAll();
    }
}

