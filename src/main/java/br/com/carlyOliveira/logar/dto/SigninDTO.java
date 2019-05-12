package br.com.carlyOliveira.logar.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SigninDTO {

	@NotBlank(message = "{msg.missing.filds}")
	@Email(message = "{msg.invalid.filds}")
	private String email;

	@NotBlank(message = "{msg.missing.filds}")
	private String password;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
