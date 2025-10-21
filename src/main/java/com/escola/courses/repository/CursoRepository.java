package com.escola.courses.repository;

import com.escola.courses.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT p from Curso p WHERE p.price = :priceInput")
    List<Curso> cursosPorPreco(@Param("priceInput") int priceInut);
    List<Curso> findAll();
}
