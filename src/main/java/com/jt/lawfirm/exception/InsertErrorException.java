package com.jt.lawfirm.exception;

public class InsertErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InsertErrorException() {
		super();
	}

	public InsertErrorException(String message) {
		super(message);
	}
	
}
