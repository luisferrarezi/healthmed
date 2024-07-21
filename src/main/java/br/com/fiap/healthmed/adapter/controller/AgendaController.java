package br.com.fiap.healthmed.adapter.controller;

import java.util.List;

import br.com.fiap.healthmed.adapter.repository.agenda.AgendaDto;

public interface AgendaController {	
	public List<AgendaDto> consultaByMedico(Long idMedico);
	public AgendaDto detalhar(Long idAgenda);
	public AgendaDto cadastrar(AgendaDto dto);	
	public AgendaDto alterar(Long idAgenda, AgendaDto dto);
	public void excluir(Long idAgenda);
    public void criarAgenda(String data, String horaPrimeiraConsulta, String horaUltimaConsulta, 
							Long idMedico, int tempoConsulta);
}
