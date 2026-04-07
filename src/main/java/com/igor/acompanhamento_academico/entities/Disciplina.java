package com.igor.acompanhamento_academico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="disciplina_tb")
@Getter
@Setter
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;
    
    @Column(length = 150, nullable = false)
    private String semestre;
    
    @Positive
    @Column(nullable = false)
    private Integer maximoFaltas;
    
    @Positive
    @Column(nullable = false)
    private Integer cargaHoraria;

    public Disciplina(){}
    public Disciplina(String name, String semestre, Integer maximoFaltas, Integer cargaHoraria){
        this.name = name;
        this.semestre = semestre;
        this.maximoFaltas = maximoFaltas;
        this.cargaHoraria = cargaHoraria;
    }

}
