package br.com.fiap.healthmed.api;

import java.net.URI;

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

import br.com.fiap.healthmed.adapter.controller.AgendamentoController;
import br.com.fiap.healthmed.adapter.repository.agendamento.AgendamentoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoApi {
	private final AgendamentoController controller;
	
	public AgendamentoApi(AgendamentoController controller) {
		this.controller = controller;
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendamentoDto> detalhar(@PathVariable @NotNull Long id){
		AgendamentoDto agendamento = controller.detalhar(id);
		
		return ResponseEntity.ok(agendamento);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendamentoDto> cadastrar(@RequestBody @Valid AgendamentoDto dto, UriComponentsBuilder uriBuilder){
		AgendamentoDto agendamento = controller.cadastrar(dto);
		URI endereco = uriBuilder.path("/agendamento/{id}").buildAndExpand(agendamento.idAgendamento()).toUri();
		
		return ResponseEntity.created(endereco).body(agendamento);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendamentoDto> alterar(@PathVariable @NotNull Long id, 
											  	  @RequestBody @Valid AgendamentoDto dto){
		AgendamentoDto agendamento = controller.alterar(id, dto);
		
		return ResponseEntity.ok(agendamento);
	}	
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendamentoDto> excluir(@PathVariable @NotNull Long id){
		controller.excluir(id);		
		
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value="/aceitar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendamentoDto> aceitar(@PathVariable @NotNull Long id){
		controller.aceitar(id);
		
		return ResponseEntity.noContent().build();
	}	
	
	@PutMapping(value="/recusar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendamentoDto> recusar(@PathVariable @NotNull Long id){
		controller.recusar(id);
		
		return ResponseEntity.noContent().build();
	}		
}
