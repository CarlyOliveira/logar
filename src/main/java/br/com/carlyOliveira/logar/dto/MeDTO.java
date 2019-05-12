package br.com.carlyOliveira.logar.dto;

import java.util.Set;

import br.com.carlyOliveira.logar.model.Phone;

public class MeDTO {

	private String firstName;
	private String lastName;
	private String email;
	private Set<Phone> phones;
	private String Created_at;
	private String last_login;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public String getCreated_at() {
		return Created_at;
	}

	public void setCreated_at(String created_at) {
		Created_at = created_at;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	@Override
	public String toString() {
		return "Me [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phones=" + phones
				+ ", Created_at=" + Created_at + ", last_login=" + last_login + "]";
	}

}
