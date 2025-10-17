package com.escola.courses.controller;

import com.escola.courses.model.Aluno;
import com.escola.courses.model.Curso;
import com.escola.courses.repository.AlunoRepository;
import com.escola.courses.repository.CursoRepository;
import com.escola.courses.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AlunoController {

    @Autowired
    private CursoRepository cursoRepository;

    private CursoService cursoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/cursos")
    public List<Curso> getAllCourses(){
        return cursoRepository.findAll();
    }

    @PostMapping("/cursos")
    public Curso postCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }
    @PostMapping("/aluno")
    public Aluno postAluno(@RequestBody Aluno aluno){
        Curso curso = new Curso();
        curso.setName("Java");
        curso.setPrice(100.00);

        aluno.setCursos((List<Curso>) curso);
        return alunoRepository.save(aluno);
    }
}
