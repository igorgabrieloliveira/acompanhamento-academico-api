package com.igor.acompanhamento_academico.dtos.matricula;

import jakarta.validation.constraints.NotNull;

public record MatriculaRequestDTO(
    @NotNull Long alunoId,
    @NotNull Long disciplinaId
) {
}