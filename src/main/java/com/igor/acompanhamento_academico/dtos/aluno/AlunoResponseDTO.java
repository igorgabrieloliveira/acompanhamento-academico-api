package com.igor.acompanhamento_academico.dtos.aluno;

import com.igor.acompanhamento_academico.entities.Aluno;

public record AlunoResponseDTO(
    Long id,
    String name,
    String email
){
    public AlunoResponseDTO(Aluno aluno) {
        this(aluno.getId(), aluno.getName(), aluno.getEmail());
    }
}