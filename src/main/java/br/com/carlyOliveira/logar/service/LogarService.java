package br.com.carlyOliveira.logar.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.carlyOliveira.logar.dto.MeDTO;
import br.com.carlyOliveira.logar.dto.SigninDTO;
import br.com.carlyOliveira.logar.exception.EmailCadastradoException;
import br.com.carlyOliveira.logar.exception.EmailInvalidException;
import br.com.carlyOliveira.logar.model.Usuario;
import br.com.carlyOliveira.logar.repository.UsuarioRepository;
import br.com.carlyOliveira.logar.security.LogarSecurityService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class LogarService {

	private UsuarioRepository usuarioRepository;

	@Autowired
	public LogarService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public String save(Usuario usuario) throws EmailCadastradoException {

		if (emailCadastrado(usuario.getEmail())) {
			throw new EmailCadastradoException();
		}

		usuarioRepository.save(usuario);

		Gson gson = new Gson();
		return gson.toJson(usuario);

	}

	public boolean emailCadastrado(String email) {
		return usuarioRepository.exists(email);
	}

	public String login(SigninDTO signin) throws EmailInvalidException {

		if (!emailCadastrado(signin.getEmail())) {
			throw new EmailInvalidException();
		}

		Usuario usuario = getUsuarioSignin(signin.getEmail());
		if (!LogarSecurityService.criptografar(signin.getPassword()).equals(usuario.getPassword())) {
			throw new EmailInvalidException();
		}

		Gson gson = new Gson();

		usuario.setLast_login(LocalDate.now());
		usuarioRepository.save(usuario);

		return LogarSecurityService.createAuthentication(gson.toJson(usuario));

	}

	public Usuario getUsuarioSignin(String email) {
		return usuarioRepository.findOne(email);
	}

	public MeDTO geMe(String token) {

		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("carlyOliveira"))
				.parseClaimsJws(token).getBody();

		MeDTO meDto = new MeDTO();
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(claims.getSubject().toString(), Usuario.class);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		meDto.setCreated_at(usuario.getCreated_at().format(formatter));
		meDto.setEmail(usuario.getEmail());
		meDto.setFirstName(usuario.getFirstName());

		if (usuario.getLast_login() != null) {
			meDto.setLast_login(usuario.getLast_login().format(formatter));
		} else {
			meDto.setLast_login("");
		}

		meDto.setLastName(usuario.getLastName());
		meDto.setPhones(usuario.getPhones());

		return meDto;
	}
}
