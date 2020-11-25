package com.sbs.dto;

import java.time.LocalDate;

import com.sbs.entities.Matricula;

public class MatriculaNewDto {

	private Integer id;
	private Integer idAluno;
	private Integer idCurso;
	private LocalDate dtmatricula;

	public MatriculaNewDto() {

	}

	public MatriculaNewDto(Matricula obj) {
		this.id = obj.getId();
		this.idAluno = obj.getAluno().getId();
		this.idCurso = obj.getCurso().getId();
		this.dtmatricula = obj.getDtMatricula();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public LocalDate getDtmatricula() {
		return dtmatricula;
	}

	public void setDtmatricula(LocalDate dtmatricula) {
		this.dtmatricula = dtmatricula;
	}

}
