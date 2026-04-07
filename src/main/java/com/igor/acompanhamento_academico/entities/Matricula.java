package com.igor.acompanhamento_academico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "matricula_tb")
@Getter
@Setter
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer faltasRegistradas = 0;
    
    
    @Column(nullable = false, length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    public Matricula() {}
    public Matricula(Integer faltasRegistradas, String status, Aluno aluno, Disciplina disciplina) {
        this.faltasRegistradas = faltasRegistradas;
        this.status = status;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

}
