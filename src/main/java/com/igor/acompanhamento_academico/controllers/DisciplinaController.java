package com.igor.acompanhamento_academico.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.acompanhamento_academico.dtos.disciplina.DisciplinaRequestDTO;
import com.igor.acompanhamento_academico.dtos.disciplina.DisciplinaResponseDTO;
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
    public ResponseEntity<DisciplinaResponseDTO> postDisciplina(@Valid @RequestBody DisciplinaRequestDTO disciplina){
        DisciplinaResponseDTO response = service.cadastrarDisciplina(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<DisciplinaResponseDTO> getDisciplinas(){
        return service.listarTodos();
    }


}
