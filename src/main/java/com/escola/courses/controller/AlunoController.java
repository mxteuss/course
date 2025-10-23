package com.escola.courses.controller;

import com.escola.courses.model.Aluno;
import com.escola.courses.model.AlunoDTO;
import com.escola.courses.model.Curso;
import com.escola.courses.repository.AlunoRepository;
import com.escola.courses.repository.CursoRepository;
import com.escola.courses.service.CursoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/get")
    public List get(){
        Page<Aluno> page = alunoRepository.findAll(PageRequest.of(0, 10));
        return page.getContent();
    }

    @GetMapping("/get/{}")
    public Aluno getId(@PathVariable Long id){
        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
    @PostMapping("/post")
    public Aluno postAluno(@RequestBody AlunoDTO dto){
        Curso curso = cursoRepository.findById(dto.cursoId()).
                orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Aluno aluno = new Aluno();

        aluno.setName(dto.name());
        aluno.setCursos(new ArrayList<>());
        aluno.getCursos().add(curso);

        return alunoRepository.save(aluno);
    }
        @PutMapping("{id}")
        @Transactional
        public ResponseEntity refresh(@PathVariable Long id, @RequestBody AlunoDTO dto){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
            Curso curso = cursoRepository.findById(dto.cursoId()).
                    orElseThrow(() -> new RuntimeException("Curso não encontrado"));

            aluno.setName(dto.name());
            aluno.setCursos(new ArrayList<>());
            aluno.getCursos().add(curso);

            return ResponseEntity.ok(alunoRepository.save(aluno));
        }
    }
