package com.sbs.dto;

import java.time.LocalDate;

import com.sbs.entities.Matricula;

public class MatriculaDto {
	
	private Integer id;
	private String nomeAluno;
	private String nomeCurso;
	private LocalDate dtmatricula;
	
	public MatriculaDto() {
		
	}
	
	public MatriculaDto(Matricula obj) {
		this.id = obj.getId();
		this.nomeAluno = (obj.getAluno()).getNome();
		this.nomeCurso = (obj.getCurso()).getNome();
		this.dtmatricula = obj.getDtMatricula();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public LocalDate getDtmatricula() {
		return dtmatricula;
	}

	public void setDtmatricula(LocalDate dtmatricula) {
		this.dtmatricula = dtmatricula;
	}

	
}
