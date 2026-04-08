package com.igor.acompanhamento_academico.dtos.atividade;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record AtividadeRequestDTO(
    @NotBlank String titulo,
    String descricao,
    @NotNull LocalDateTime dataEntrega,
    @PositiveOrZero @NotNull Double nota,
    @NotNull Long idMatricula
) {

}
