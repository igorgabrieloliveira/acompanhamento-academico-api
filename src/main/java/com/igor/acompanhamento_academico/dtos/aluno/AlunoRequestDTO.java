package com.igor.acompanhamento_academico.dtos.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AlunoRequestDTO(
    @NotBlank String name,
    @Email @NotBlank String email,
    @NotBlank String password)
{}
