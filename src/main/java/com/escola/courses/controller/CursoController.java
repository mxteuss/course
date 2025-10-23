package com.escola.courses.controller;


import com.escola.courses.model.Aluno;
import com.escola.courses.model.Curso;
import com.escola.courses.model.CursoDTO;
import com.escola.courses.repository.AlunoRepository;
import com.escola.courses.repository.CursoRepository;
import com.escola.courses.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/cursos")
@AllArgsConstructor
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/get")
    public List<Curso> getAllCourses(){
    Page<Curso> page = cursoRepository.findAll(PageRequest.of(0, 10));
    return page.getContent();
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

    @GetMapping("/free")
    public ResponseEntity free(){
        return ResponseEntity.ok(cursoRepository.cursosPorPreco(25));
    }
}
