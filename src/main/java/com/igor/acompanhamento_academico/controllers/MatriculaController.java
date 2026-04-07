package com.igor.acompanhamento_academico.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.acompanhamento_academico.entities.Matricula;
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
    public Matricula postMatricula(@Valid @RequestBody Matricula matricula){
        return service.cadastrarMatricula(matricula);
    }

    @GetMapping
    public List<Matricula> getMatricula(){
        return service.listarTodas();
    }

}
