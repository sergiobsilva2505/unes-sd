package com.sbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbs.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
