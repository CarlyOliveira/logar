package br.com.carlyOliveira.logar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private long number;

	private long area_code;

	private String country_code;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Number getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public Number getArea_code() {
		return area_code;
	}

	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	@Override
	public String toString() {
		return "Phones [id=" + id + ", number=" + number + ", area_code=" + area_code + ", country_code=" + country_code
				+ "]";
	}

}
