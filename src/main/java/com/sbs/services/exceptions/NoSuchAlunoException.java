package com.sbs.services.exceptions;

public class NoSuchAlunoException extends NullPointerException {
	private static final long serialVersionUID = 1L;
	
	public NoSuchAlunoException(String s) {
		super(s);
	}

}
