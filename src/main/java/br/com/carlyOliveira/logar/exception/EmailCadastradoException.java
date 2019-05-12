package br.com.carlyOliveira.logar.exception;

public class EmailCadastradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailCadastradoException() {
		super("E-mail already exists.");
	}
}
