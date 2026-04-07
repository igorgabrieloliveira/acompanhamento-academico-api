package com.igor.acompanhamento_academico.dtos.matricula;

import com.igor.acompanhamento_academico.dtos.aluno.AlunoResponseDTO;
import com.igor.acompanhamento_academico.dtos.disciplina.DisciplinaResponseDTO;
import com.igor.acompanhamento_academico.entities.Matricula;

public record MatriculaResponseDTO(
    Long id,
    Integer faltasRegistradas,
    String status,
    AlunoResponseDTO aluno,          
    DisciplinaResponseDTO disciplina 
) {
    public MatriculaResponseDTO(Matricula matricula) {
        this(
            matricula.getId(),
            matricula.getFaltasRegistradas(),
            matricula.getStatus(),
            new AlunoResponseDTO(matricula.getAluno()),         // Converte o aluno
            new DisciplinaResponseDTO(matricula.getDisciplina()) // Converte a disciplina
        );
    }
}