package br.com.fiap.healthmed.adapter.controller;

import br.com.fiap.healthmed.adapter.repository.agendamento.AgendamentoDto;

public interface AgendamentoController {
	public AgendamentoDto detalhar(Long idAgendamento);
	public AgendamentoDto cadastrar(AgendamentoDto dto);
	public AgendamentoDto alterar(Long idAgendamento, AgendamentoDto dto);
	public void excluir(Long idAgendamento);
	public void aceitar(Long idAgendamento);	
	public void recusar(Long idAgendamento);
}
