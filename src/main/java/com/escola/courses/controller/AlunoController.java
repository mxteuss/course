package com.escola.courses.controller;

import com.escola.courses.model.Aluno;
import com.escola.courses.model.Curso;
import com.escola.courses.repository.AlunoRepository;
import com.escola.courses.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private CursoService cursoService;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private AlunoRepository alunoRepository;


    @PostMapping("/get")
    public Aluno postAluno(@RequestBody Aluno aluno){

        Curso curso = new Curso();
        curso.setName("Java");
        curso.setPrice(100.00);
        try {
            aluno.setCursos((List<Curso>) curso);
        }
        catch (ClassCastException e){
            e.printStackTrace();
        }
        return alunoRepository.save(aluno);
    }
}
