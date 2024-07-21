package br.com.fiap.healthmed.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.fiap.healthmed.adapter.controller.AgendaController;
import br.com.fiap.healthmed.adapter.repository.agenda.AgendaDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaApi {
	private final AgendaController controller;
	
	public AgendaApi(AgendaController controller) {
		this.controller = controller;
	}
	
	@GetMapping(value="/medico/{idMedico}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AgendaDto> consultarByMedico(@PathVariable @NotNull Long idMedico){
		
		return controller.consultaByMedico(idMedico);
	}	
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendaDto> detalhar(@PathVariable @NotNull Long id){
		AgendaDto agenda = controller.detalhar(id);
		
		return ResponseEntity.ok(agenda);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendaDto> cadastrar(@RequestBody @Valid AgendaDto dto, UriComponentsBuilder uriBuilder){
		AgendaDto agenda = controller.cadastrar(dto);
		URI endereco = uriBuilder.path("/agenda/{id}").buildAndExpand(agenda.idAgenda()).toUri();
		
		return ResponseEntity.created(endereco).body(agenda);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendaDto> alterar(@PathVariable @NotNull Long id, 
											  @RequestBody @Valid AgendaDto dto){
		AgendaDto agenda = controller.alterar(id, dto);
		
		return ResponseEntity.ok(agenda);
	}	
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendaDto> excluir(@PathVariable @NotNull Long id){
		controller.excluir(id);		
		
		return ResponseEntity.noContent().build();
	}

	@PostMapping(value = "/criar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> criar(@RequestBody String json){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(json);
			ObjectNode objectNode = (ObjectNode) jsonNode;
			
			controller.criarAgenda(objectNode.get("data").asText(), 
								   objectNode.get("horaPrimeiraConsulta").asText(), 
								   objectNode.get("horaUltimaConsulta").asText(), 
								   objectNode.get("idMedico").asLong(), 
								   objectNode.get("tempoConsulta").asInt());
								   
			return ResponseEntity.ok().build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return ResponseEntity.badRequest().build();		
	}
}
