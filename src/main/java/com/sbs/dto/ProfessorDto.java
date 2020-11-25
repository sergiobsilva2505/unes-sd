package com.sbs.dto;

import java.io.Serializable;

import com.sbs.entities.Professor;

public class ProfessorDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

	public ProfessorDto() {
		super();
	}

	public ProfessorDto(Professor obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
