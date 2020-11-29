package com.sbs.dto;

import java.io.Serializable;

public class AlunoNewDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//private Integer id;
	private String nome;
	//private Integer idCurso;

	public AlunoNewDto() {
		super();
	}

	public AlunoNewDto(String nome) {
		super();
		//this.id = id;
		this.nome = nome;
		//this.idCurso = idCurso;
	}

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public Integer getIdCurso() {
//		return idCurso;
//	}
//
//	public void setIdCurso(Integer idCurso) {
//		this.idCurso = idCurso;
//	}



}
