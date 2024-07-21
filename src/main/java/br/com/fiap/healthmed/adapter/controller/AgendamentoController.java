package br.com.fiap.healthmed.adapter.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fiap.healthmed.adapter.repository.agendamento.AgendamentoDto;

public interface AgendamentoController {
	public Page<AgendamentoDto> consultaPaginada(Pageable paginacao);
	public AgendamentoDto detalhar(Long idAgendamento);
	public AgendamentoDto cadastrar(AgendamentoDto dto);	
	public AgendamentoDto alterar(Long idAgendamento, AgendamentoDto dto);
	public void excluir(Long idAgendamento);
}
