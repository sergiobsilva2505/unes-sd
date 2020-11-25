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
import com.sbs.services.exceptions.DataIntegrityException;

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
	public List<Curso> findAll(){
		return cursoRepository.findAll();
	}
	
	// UPDATE
	public Curso update(Curso obj) {
		Curso newObj = findById(obj.getId());
		updateData(newObj, obj);
		return cursoRepository.save(newObj);
	}
	
	// DELETE
	public void delete(Integer id) {
		findById(id);
		try {
			cursoRepository.deleteById(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Impossivel excluir!!");
		}
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
		return new Curso(objDto.getId(), objDto.getNome(), null, null);
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
