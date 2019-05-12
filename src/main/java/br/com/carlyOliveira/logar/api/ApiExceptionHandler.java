package br.com.carlyOliveira.logar.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlyOliveira.logar.exception.EmailCadastradoException;
import br.com.carlyOliveira.logar.exception.EmailInvalidException;
import br.com.carlyOliveira.logar.model.ErrorApi;
import io.jsonwebtoken.ExpiredJwtException;

@RestController
@ControllerAdvice
public class ApiExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmailCadastradoException.class)
	public ErrorApi emailException(EmailCadastradoException ex) {
		return new ErrorApi(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmailInvalidException.class)
	public ErrorApi emailException(EmailInvalidException ex) {
		return new ErrorApi(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorApi fieldsException(MethodArgumentNotValidException ex) {
		return new ErrorApi(ex.getBindingResult().getFieldError().getDefaultMessage(),
				HttpStatus.BAD_REQUEST.toString());
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(ServletRequestBindingException.class)
	public ErrorApi handleException(ServletRequestBindingException ex) {
		return new ErrorApi("Unauthorized", HttpStatus.UNAUTHORIZED.toString());
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(ExpiredJwtException.class)
	public ErrorApi handleException(ExpiredJwtException ex) {
		return new ErrorApi("Unauthorized - invalid session", HttpStatus.UNAUTHORIZED.toString());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ErrorApi handleException(Exception ex) {
		return new ErrorApi(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
	}

}
