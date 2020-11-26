package com.sbs.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.dto.AlunoDto;
import com.sbs.dto.AlunoNewDto;
import com.sbs.entities.Aluno;
import com.sbs.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	// ***** INSERT *****
	@Transactional
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		obj = alunoRepository.save(obj);

		return obj;
	}

	// ***** UPDATE *****
	public Aluno update(Aluno obj) {
		Aluno newObj = findById(obj.getId());
		updateData(newObj, obj);
		return alunoRepository.save(newObj);
	}

	// ***** FINDBYID *****
	public Aluno findById(Integer id) {
		Optional<Aluno> obj = alunoRepository.findById(id);
		return obj.orElse(null);
	}

	// ***** FINDALL *****
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	// **** MÉTODO AUXILIAR *****
	private void updateData(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
	}

	public Aluno fromDto(AlunoDto objDto) {
		return new Aluno(objDto.getId(), objDto.getNome());
	}

	public Aluno fromNewDto(AlunoNewDto obj) {
		Aluno newAluno = new Aluno(null, obj.getNome());
		return newAluno;
	}

}
