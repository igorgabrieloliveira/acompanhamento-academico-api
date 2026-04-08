package com.igor.acompanhamento_academico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.acompanhamento_academico.entities.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{
    List<Atividade> findByMatricula_Aluno_IdAndStatusOrderByDataEntregaAsc(Long alunoId, String status);
}
