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

import com.igor.acompanhamento_academico.dtos.aluno.AlunoRequestDTO;
import com.igor.acompanhamento_academico.dtos.aluno.AlunoResponseDTO;
import com.igor.acompanhamento_academico.dtos.atividade.AtividadeResponseDTO;
import com.igor.acompanhamento_academico.services.AlunoService;
import com.igor.acompanhamento_academico.services.AtividadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

   private final AlunoService service;
    private final AtividadeService atividadeService; 

    public AlunoController(AlunoService service, AtividadeService atividadeService){
        this.service = service;
        this.atividadeService = atividadeService;
    }
    
    @PostMapping
    public ResponseEntity<AlunoResponseDTO> postAluno(@Valid @RequestBody AlunoRequestDTO aluno){
        AlunoResponseDTO response = service.cadastrarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}/atividades/pendentes")
    public ResponseEntity<List<AtividadeResponseDTO>> getAtividadesPendentes(@PathVariable Long id){
        List<AtividadeResponseDTO> lista = atividadeService.listarPendentesPorAluno(id);
        return ResponseEntity.ok(lista);
    }

}
