package com.igor.acompanhamento_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.acompanhamento_academico.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{}
