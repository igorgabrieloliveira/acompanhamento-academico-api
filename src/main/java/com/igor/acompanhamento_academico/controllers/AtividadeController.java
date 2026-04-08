package com.igor.acompanhamento_academico.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.acompanhamento_academico.dtos.atividade.AtividadeRequestDTO;
import com.igor.acompanhamento_academico.dtos.atividade.AtividadeResponseDTO;
import com.igor.acompanhamento_academico.services.AtividadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    private final AtividadeService service;

    public AtividadeController(AtividadeService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AtividadeResponseDTO> postAtividade(@Valid @RequestBody AtividadeRequestDTO atividadeDto){
        AtividadeResponseDTO response = service.cadastrarAtividade(atividadeDto); 
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AtividadeResponseDTO>> getAtividades(){
        List<AtividadeResponseDTO> listAtividadeDto = service.listarTodas();
        return ResponseEntity.ok(listAtividadeDto);
    }

   

}
