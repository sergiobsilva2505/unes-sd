package com.sbs.services.exceptions;

public class NoSuchCursoException extends NullPointerException{
	private static final long serialVersionUID = 1L;
	
	public NoSuchCursoException(String s) {
		super(s);
	}
}
