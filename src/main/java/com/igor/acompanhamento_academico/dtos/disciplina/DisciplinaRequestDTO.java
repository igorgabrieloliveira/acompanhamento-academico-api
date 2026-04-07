package com.igor.acompanhamento_academico.dtos.disciplina;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DisciplinaRequestDTO(
    @NotBlank String name,
    @NotBlank String semestre,
    @Positive Integer maximoFaltas,
    @Positive Integer cargaHoraria
) {  
}
