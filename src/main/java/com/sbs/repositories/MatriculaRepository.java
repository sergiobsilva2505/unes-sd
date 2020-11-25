package com.sbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbs.entities.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

}
