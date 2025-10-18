package com.escola.courses.controller;


import com.escola.courses.model.Curso;
import com.escola.courses.repository.CursoRepository;
import com.escola.courses.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@AllArgsConstructor
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/get")
    public List<Curso> getAllCourses(){
        return cursoRepository.findAll();
    }

    @PostMapping("/post")
    public Curso postCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }
}
