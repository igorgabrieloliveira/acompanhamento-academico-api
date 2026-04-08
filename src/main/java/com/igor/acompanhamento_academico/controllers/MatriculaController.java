package com.igor.acompanhamento_academico.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.acompanhamento_academico.dtos.matricula.MatriculaRequestDTO;
import com.igor.acompanhamento_academico.dtos.matricula.MatriculaResponseDTO;
import com.igor.acompanhamento_academico.services.MatriculaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MatriculaResponseDTO> postMatricula(@Valid @RequestBody MatriculaRequestDTO matricula){
        MatriculaResponseDTO response = service.cadastrarMatricula(matricula);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<MatriculaResponseDTO> getMatriculas(){
        return service.listarTodas();
    }

}
