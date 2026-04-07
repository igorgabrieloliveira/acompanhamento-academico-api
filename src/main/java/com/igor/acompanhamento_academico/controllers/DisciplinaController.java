package com.igor.acompanhamento_academico.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.acompanhamento_academico.entities.Disciplina;
import com.igor.acompanhamento_academico.services.DisciplinaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service){
        this.service = service;
    }

    @PostMapping
    public Disciplina postDisciplina(@Valid @RequestBody Disciplina disciplina){
        return service.cadastrarDisciplina(disciplina);
    }

    @GetMapping
    public List<Disciplina> getDisciplina(){
        return service.listarTodos();
    }


}
