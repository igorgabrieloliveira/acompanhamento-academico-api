package com.igor.acompanhamento_academico.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.acompanhamento_academico.dtos.atividade.AtividadeResponseDTO;
import com.igor.acompanhamento_academico.dtos.matricula.MatriculaRequestDTO;
import com.igor.acompanhamento_academico.dtos.matricula.MatriculaResponseDTO;
import com.igor.acompanhamento_academico.services.AtividadeService;
import com.igor.acompanhamento_academico.services.MatriculaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;
    private final AtividadeService serviceAtividade;

    public MatriculaController(MatriculaService service, AtividadeService serviceAtividade){
        this.service = service;
        this.serviceAtividade = serviceAtividade;
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

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponseDTO> getMatriculaById(@PathVariable Long id){
        MatriculaResponseDTO response = service.getById(id);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}/atividades")
    public ResponseEntity<List<AtividadeResponseDTO>> getAtividadesByMatricula(@PathVariable Long id){
        List<AtividadeResponseDTO> listDto = serviceAtividade.listarAtividadesPorMatricula(id);
        
        return ResponseEntity.ok(listDto);
    }
}
