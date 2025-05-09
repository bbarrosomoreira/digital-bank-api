package br.com.cdb.bancodigitaljpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdb.bancodigitaljpa.dto.LoginDTO;
import br.com.cdb.bancodigitaljpa.dto.RegistroUsuarioDTO;
import br.com.cdb.bancodigitaljpa.response.LoginResponse;
import br.com.cdb.bancodigitaljpa.service.AuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	/**
	 * Endpoint para cadastro de usuário (retorna token JWT após registro)
	 */
	@PostMapping("/signin")
	public ResponseEntity<LoginResponse> registrar(@Valid @RequestBody RegistroUsuarioDTO dto) {
		LoginResponse response = authService.registrar(dto);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Endpoint para login de usuário (retorna token JWT)
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> autenticar(@Valid @RequestBody LoginDTO dto) {
		LoginResponse response = authService.autenticar(dto);
		return ResponseEntity.ok(response);
	}
	


}
