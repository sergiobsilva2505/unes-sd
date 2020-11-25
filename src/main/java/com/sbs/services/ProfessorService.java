package com.sbs.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.dto.ProfessorDto;
import com.sbs.entities.Professor;
import com.sbs.repositories.ProfessorRepository;
import com.sbs.services.exceptions.DataIntegrityException;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	// ***** INSERT *****
		@Transactional
		public Professor insert(Professor obj) {
			obj.setId(null);
			obj = professorRepository.save(obj);
			
			return obj;
		}

		// ***** UPDATE *****
		public Professor update(Professor obj) {
			Professor newObj = findById(obj.getId());
			updateData(newObj, obj);
			return professorRepository.save(newObj);
		}

		// ***** DELETE *****
		public void delete(Integer id) {
			findById(id);
			try {
				professorRepository.deleteById(id);
			} catch (DataIntegrityException e) {
				throw new DataIntegrityException("Impossivel excluir!!");
			}
		}

		// ***** FINDBYID *****
		public Professor findById(Integer id) {
			Optional<Professor> obj = professorRepository.findById(id);
			return obj.orElse(null);
		}

		// ***** FINDALL *****
		public List<Professor> findAll() {
			return professorRepository.findAll();
		}

		// **** MÉTODO AUXILIAR *****
		private void updateData(Professor newObj, Professor obj) {
			newObj.setNome(obj.getNome());
		}

		public Professor fromDto(ProfessorDto objDto) {
			return new Professor(objDto.getId(), objDto.getNome());
		}

//		public Professor fromNewDto(ProfessorNewDto obj) {
//			Professor newProfessor = new Professor(null, obj.getNome());
//			return newProfessor;
//		}

	
	

}
