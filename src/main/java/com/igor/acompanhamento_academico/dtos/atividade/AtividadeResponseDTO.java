package com.igor.acompanhamento_academico.dtos.atividade;

import java.time.LocalDateTime;

import com.igor.acompanhamento_academico.dtos.matricula.MatriculaResponseDTO;
import com.igor.acompanhamento_academico.entities.Atividade;

public record AtividadeResponseDTO(
    Long id,
    String titulo,
    String descricao,
    LocalDateTime dataEntrega,
    Double nota,
    String status,
    MatriculaResponseDTO matricula
) {
    public AtividadeResponseDTO(Atividade atividade){

        this(atividade.getId(), atividade.getTitulo(), atividade.getDescricao(), atividade.getDataEntrega(), atividade.getNota(), atividade.getStatus(), new MatriculaResponseDTO(atividade.getMatricula()));
    }
}
