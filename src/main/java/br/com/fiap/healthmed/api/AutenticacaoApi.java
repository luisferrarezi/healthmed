package br.com.fiap.healthmed.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.healthmed.adapter.controller.AutenticacaoController;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/autenticacao")
public class AutenticacaoApi {	
	
	private final AutenticacaoController controller;
	
	public AutenticacaoApi(AutenticacaoController controller) {
		this.controller = controller;
	}
	
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(@RequestParam("login") String login, 
                                        @RequestParam("senha") String senha){
        controller.login(login, senha);
		return ResponseEntity.noContent().build();
	}

	@PostMapping(value = "/logout/{idAutenticacao}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> logout(@PathVariable @NotNull Long idAutenticacao){
        controller.logout(idAutenticacao);
		return ResponseEntity.noContent().build();
	}    
}
