package com.igor.acompanhamento_academico.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="aluno_tb")
@Getter
@Setter
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false, length = 200)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    // @OneToMany(mappedBy = "aluno")
    // private List<Disciplina> disciplinas = new ArrayList<>();

    public Aluno(){}
    public Aluno(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }


}
