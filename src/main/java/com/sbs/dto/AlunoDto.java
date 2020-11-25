package com.sbs.dto;

import com.sbs.entities.Aluno;

public class AlunoDto {

	private Integer id;
	private String nome;

	public AlunoDto() {
		super();
	}

	public AlunoDto(Aluno obj) {
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
