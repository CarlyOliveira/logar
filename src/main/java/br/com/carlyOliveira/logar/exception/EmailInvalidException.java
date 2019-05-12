package br.com.carlyOliveira.logar.exception;

public class EmailInvalidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailInvalidException() {
		super("Invalid email or password");
	}
}
