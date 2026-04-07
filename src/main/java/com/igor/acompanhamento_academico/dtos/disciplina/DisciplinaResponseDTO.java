package com.igor.acompanhamento_academico.dtos.disciplina;

import com.igor.acompanhamento_academico.entities.Disciplina;

public record DisciplinaResponseDTO(
    Long id,
    String name,
    String semestre,
    Integer maximoFaltas,
    Integer cargaHoraria
) {
    public DisciplinaResponseDTO(Disciplina disciplina) {
        this(disciplina.getId(), disciplina.getName(), disciplina.getSemestre(), 
             disciplina.getMaximoFaltas(), disciplina.getCargaHoraria());
    }
}