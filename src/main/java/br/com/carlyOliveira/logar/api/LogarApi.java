package br.com.carlyOliveira.logar.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlyOliveira.logar.dto.MeDTO;
import br.com.carlyOliveira.logar.dto.SigninDTO;
import br.com.carlyOliveira.logar.dto.UsuarioRequestDTO;
import br.com.carlyOliveira.logar.dto.UsuarioResponseDTO;
import br.com.carlyOliveira.logar.security.LogarSecurityService;
import br.com.carlyOliveira.logar.service.LogarService;

@RestController
public class LogarApi {

	private LogarService logarService;

	@Autowired
	public LogarApi(LogarService logarService) {
		this.logarService = logarService;
	}

	@PostMapping
	@RequestMapping("/signup")
	public ResponseEntity<UsuarioResponseDTO> save(@RequestBody @Valid UsuarioRequestDTO usuarioDto) throws Exception {

		return new ResponseEntity<>(
				UsuarioResponseDTO.gerarUsuarioResponseDTO(
						LogarSecurityService.createAuthentication(logarService.save(usuarioDto.gerarUsuario()))),
				HttpStatus.CREATED);
	}

	@PostMapping
	@RequestMapping("/signin")
	public ResponseEntity<UsuarioResponseDTO> signin(@RequestBody @Valid SigninDTO signin) throws Exception {
		return new ResponseEntity<>(UsuarioResponseDTO.gerarUsuarioResponseDTO(logarService.login(signin)),
				HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping("/me")
	public ResponseEntity<MeDTO> teste(@RequestHeader("Authorization") String token  ) {
		return new ResponseEntity<>(logarService.geMe(token), HttpStatus.OK);
	}

}
