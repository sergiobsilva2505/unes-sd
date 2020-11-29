package com.sbs.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.dto.CursoNewDto;
import com.sbs.entities.Curso;
import com.sbs.entities.Professor;
import com.sbs.repositories.CursoRepository;
import com.sbs.repositories.ProfessorRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	// FIND BY ID
	public Curso findById(Integer id) {
		Optional<Curso> obj = cursoRepository.findById(id);
		return obj.orElse(null);
	}

	// FIND ALL
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	// UPDATE
	public Curso update(Curso obj) {
		Curso newObj = findById(obj.getId());
		updateData(newObj, obj);
		return cursoRepository.save(newObj);
	}

	// INSERT
	@Transactional
	public Curso insert(Curso obj) {
		obj.setId(null);
		obj = cursoRepository.save(obj);
		return obj;
	}

	// MÉTODOS AUXILIARES
	private void updateData(Curso newObj, Curso obj) {
		newObj.setNome(obj.getNome());
		newObj.setProfessor(obj.getProfessor());
	}

	public Curso fromDto(CursoNewDto objDto) {
		Professor prof = professorRepository.getOne(objDto.getIdProfessor());
		return new Curso(objDto.getNome(), objDto.getSigla(), prof);
	}

	public Curso fromNewDto(CursoNewDto obj) {
		Professor prof = professorRepository.getOne(obj.getIdProfessor());
		Curso newCurso = new Curso();
		newCurso.setNome(obj.getNome());
		newCurso.setSigla(obj.getDescricao());
		newCurso.setProfessor(prof);
		return newCurso;
	}

}
