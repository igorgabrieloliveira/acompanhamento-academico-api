package com.igor.acompanhamento_academico.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igor.acompanhamento_academico.dtos.matricula.MatriculaRequestDTO;
import com.igor.acompanhamento_academico.dtos.matricula.MatriculaResponseDTO;
import com.igor.acompanhamento_academico.entities.Aluno;
import com.igor.acompanhamento_academico.entities.Disciplina;
import com.igor.acompanhamento_academico.entities.Matricula;
import com.igor.acompanhamento_academico.repositories.AlunoRepository;
import com.igor.acompanhamento_academico.repositories.DisciplinaRepository;
import com.igor.acompanhamento_academico.repositories.MatriculaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository repository;
    private final AlunoRepository repositoryAluno;
    private final DisciplinaRepository repositoryDisciplina;
    public MatriculaService(MatriculaRepository repository, AlunoRepository repositoryAluno, DisciplinaRepository repositoryDisciplina){
        this.repository = repository;
        this.repositoryAluno = repositoryAluno;
        this.repositoryDisciplina = repositoryDisciplina;
    }

    public MatriculaResponseDTO cadastrarMatricula(MatriculaRequestDTO dto){
        Aluno alunoByDtoId = repositoryAluno.findById(dto.alunoId()).orElseThrow(() -> new RuntimeException("Aluno nao encontrado"));
        
        Disciplina disciplinaByDtoId = repositoryDisciplina.findById(dto.disciplinaId()).orElseThrow(() -> new RuntimeException("Disciplina nao encontrada"));
        Matricula newMatricula = new Matricula(0, "CURSANDO", alunoByDtoId, disciplinaByDtoId);

        Matricula save = repository.save(newMatricula);

        return new MatriculaResponseDTO(save); 
    }

    public List<MatriculaResponseDTO> listarTodas(){
        List<MatriculaResponseDTO> listDto = repository.findAll().stream().map(n -> new MatriculaResponseDTO(n)).toList();
        return listDto;
    }
}

