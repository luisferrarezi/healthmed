package br.com.fiap.healthmed.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.fiap.healthmed.adapter.controller.AutenticacaoController;
import br.com.fiap.healthmed.adapter.repository.autenticacao.ResponseDTO;
import br.com.fiap.healthmed.infra.security.TokenBlacklist;
import br.com.fiap.healthmed.infra.security.TokenService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/autenticacao")
public class AutenticacaoApi {	
	
	private final AutenticacaoController controller;
	private final TokenBlacklist tokenBlacklist;
	private final TokenService tokenService;
	
	public AutenticacaoApi(AutenticacaoController controller, TokenBlacklist tokenBlacklist, TokenService tokenService) {
		this.controller = controller;
		this.tokenBlacklist = tokenBlacklist;
		this.tokenService = tokenService;
	}
	
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(@RequestBody String json){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(json);
			ObjectNode objectNode = (ObjectNode) jsonNode;
			
			ResponseDTO response = controller.login(objectNode.get("login").asText(), objectNode.get("senha").asText());

			if (response != null){
				return ResponseEntity.ok(response);
			} else {
				return ResponseEntity.badRequest().build();
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return ResponseEntity.badRequest().build();
	}

	@PostMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> logout(HttpServletRequest request){
		tokenBlacklist.addToBlacklist(tokenService.recoverToken(request));
		return ResponseEntity.ok().build();
	}	
}
