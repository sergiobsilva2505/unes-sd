package com.sbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbs.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
