package br.com.carlyOliveira.logar.dto;

public class UsuarioResponseDTO {

	private String token;

	public static UsuarioResponseDTO gerarUsuarioResponseDTO(String token) {
		return new UsuarioResponseDTO(token);
	}

	public UsuarioResponseDTO(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
