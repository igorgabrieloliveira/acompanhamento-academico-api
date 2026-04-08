package com.igor.acompanhamento_academico.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "atividade_tb")
@Getter
@Setter
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(length = 500)
    private String descricao;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataEntrega;

    @PositiveOrZero
    @Column(nullable = false)
    private Double nota;

    @Column(length = 50, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    public Atividade(){}
    public Atividade(String titulo, String descricao, LocalDateTime dataEntrega, Double nota, String status, Matricula matricula){
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.nota = nota;
        this.status = status;
        this.matricula = matricula;
    }

}
