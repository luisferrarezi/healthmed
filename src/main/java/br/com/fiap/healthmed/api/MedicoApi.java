package br.com.fiap.healthmed.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.healthmed.adapter.controller.MedicoController;
import br.com.fiap.healthmed.adapter.repository.medico.MedicoDto;
import br.com.fiap.healthmed.core.enums.Especializacao;

@RestController
@RequestMapping(value = "/medico")
public class MedicoApi {
	private final MedicoController controller;
	
	public MedicoApi(MedicoController controller) {
		this.controller = controller;
	}
	
	@GetMapping(value = "/consulta", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MedicoDto> consultar(@RequestParam("nome") String nome, 
                                     @RequestParam("especializacao") Especializacao especializacao, 
                                     @RequestParam("idAutenticacao") long idAutenticacao){
        
		return controller.consultar(nome, especializacao, idAutenticacao);
	}
}
