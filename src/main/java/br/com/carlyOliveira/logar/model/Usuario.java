package br.com.carlyOliveira.logar.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.carlyOliveira.logar.security.LogarSecurityService;

@Entity
public class Usuario {

	@Id
	private String email;

	private String firstName;

	private String lastName;

	private String password;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id")
	private Set<Phone> phones;

	private LocalDate Created_at;

	private LocalDate last_login;

	public Usuario() {
		super();
	}

	public Usuario(String firstName, String lastName, String email, String password, Set<Phone> phones) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = LogarSecurityService.criptografar(password);
		this.phones = phones;
		this.Created_at = LocalDate.now();
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

	public LocalDate getCreated_at() {
		return Created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		Created_at = created_at;
	}

	public LocalDate getLast_login() {
		return last_login;
	}

	public void setLast_login(LocalDate last_login) {
		this.last_login = last_login;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", phones=" + phones + ", Created_at=" + Created_at + ", last_login=" + last_login + "]";
	}

}
