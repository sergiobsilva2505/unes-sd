package com.sbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbs.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
