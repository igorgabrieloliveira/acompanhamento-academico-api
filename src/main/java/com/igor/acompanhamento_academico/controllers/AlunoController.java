package com.igor.acompanhamento_academico.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.acompanhamento_academico.entities.Aluno;
import com.igor.acompanhamento_academico.services.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service){
        this.service = service;
    }

    @PostMapping
    public Aluno postAluno(@Valid @RequestBody Aluno aluno){
        return service.cadastrarAluno(aluno);
    }

}
