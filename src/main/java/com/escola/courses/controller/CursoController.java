package com.escola.courses.controller;


import com.escola.courses.model.Curso;
import com.escola.courses.repository.CursoRepository;
import com.escola.courses.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/get/{id}")
    public Curso getId(@PathVariable Long id){
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @PostMapping("/post")
    public Curso postCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        cursoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
