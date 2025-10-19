package com.escola.courses.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Table(name = "alunos")
@Data
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
        name = "aluno_curso",
        joinColumns = @JoinColumn(name = "aluno_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos;

    public Aluno() {
    }

    public  Aluno(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
