package com.igor.acompanhamento_academico.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.acompanhamento_academico.dtos.aluno.AlunoRequestDTO;
import com.igor.acompanhamento_academico.dtos.aluno.AlunoResponseDTO;
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
    public ResponseEntity<AlunoResponseDTO> postAluno(@Valid @RequestBody AlunoRequestDTO aluno){
        AlunoResponseDTO response = service.cadastrarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
