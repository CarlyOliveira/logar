package br.com.carlyOliveira.logar.dto;

import java.util.Set;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.carlyOliveira.logar.model.Phone;
import br.com.carlyOliveira.logar.model.Usuario;

public class UsuarioRequestDTO {

	@NotBlank(message = "{msg.missing.filds}")
	private String firstName;
	@NotBlank(message = "{msg.missing.filds}")
	private String lastName;
	@Email(message = "{msg.invalid.filds}")
	@NotBlank(message = "{msg.missing.filds}")
	private String email;
	@NotBlank(message = "{msg.missing.filds}")
	private String password;
	@NotEmpty(message = "{msg.missing.filds}")
	private Set<Phone> phones;

	public Usuario gerarUsuario() {
		return new Usuario(firstName, lastName, email, password, phones);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

}
