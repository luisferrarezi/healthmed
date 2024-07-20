package br.com.fiap.healthmed.adapter.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fiap.healthmed.adapter.repository.agenda.AgendaDto;

public interface AgendaController {	
	public Page<AgendaDto> consultaPaginada(Pageable paginacao);
	public AgendaDto detalhar(Long idAgenda);
	public AgendaDto cadastrar(AgendaDto dto);	
	public AgendaDto alterar(Long idAgenda, AgendaDto dto);
	public void excluir(Long idAgenda);
}
