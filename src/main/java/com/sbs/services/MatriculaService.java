package com.sbs.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.dto.MatriculaDto;
import com.sbs.dto.MatriculaNewDto;
import com.sbs.entities.Aluno;
import com.sbs.entities.Curso;
import com.sbs.entities.Matricula;
import com.sbs.repositories.AlunoRepository;
import com.sbs.repositories.CursoRepository;
import com.sbs.repositories.MatriculaRepository;
import com.sbs.services.exceptions.NoSuchAlunoException;
import com.sbs.services.exceptions.NoSuchCursoException;
import com.sbs.services.exceptions.ObjectNotFoundException;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	// ** buscar todas as matriculas*/
	public List<Matricula> findAll() {
		List<Matricula> lista = matriculaRepository.findAll();
		return lista;
	}

	// **BUSCA MATRICULAS POR ID*/
	public Matricula findById(Integer id) {
		Optional<Matricula> obj = matriculaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Matricula.class.getName()));
	}

	// ** INSERE MATRICULA */
	public Matricula insert(Matricula obj) {
		obj.setId(null);
		obj = matriculaRepository.save(obj);
		return obj;
	}

	// ** métodos auxiliares */
	public MatriculaDto fromDto(Matricula obj) {
		MatriculaDto mat = new MatriculaDto();
		mat.setId(obj.getId());
		mat.setNomeAluno(obj.getAluno().getNome());
		mat.setNomeCurso(obj.getCurso().getNome());
		mat.setDtmatricula(obj.getDtMatricula());
		return mat;
	}

	// ** métodos auxiliaries */
	public Matricula fromNewDto(MatriculaNewDto newObj) {
		LocalDate hoje = LocalDate.now();
		Matricula mat = new Matricula();
		Optional<Aluno> optAluno = alunoRepository.findById(newObj.getIdAluno());
		Optional<Curso> optCurso = cursoRepository.findById(newObj.getIdCurso());
		Aluno aluno = optAluno.orElseThrow(() -> new NoSuchAlunoException("Aluno não existe"));
		Curso curso = optCurso.orElseThrow(() -> new NoSuchCursoException("Curso não existe"));
		//if (aluno != null && curso != null) {
			mat.setAluno(aluno);
			mat.setCurso(curso);
			mat.setDtMatricula(hoje);
			//return insert(mat);
			return mat;
		//} else {
		//	throw new NoSuchCursoException("Para efetuar matricula, informe aluno e curso.");
		//}

	}

}
