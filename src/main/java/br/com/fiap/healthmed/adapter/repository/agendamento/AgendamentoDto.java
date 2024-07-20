package br.com.fiap.healthmed.adapter.repository.agendamento;

import br.com.fiap.healthmed.core.entity.agendamento.Agendamento;

public record AgendamentoDto(
        	long idAgendamento,
			long idAgenda,
			long idPaciente,
			int confirmadoMedico,
			int confirmadoPaciente) {
	
	public AgendamentoDto(Agendamento agendamento) {
		this(agendamento.getIdAgendamento(), agendamento.getIdAgenda(), agendamento.getIdPaciente(),
			 agendamento.getConfirmadoMedico(), agendamento.getConfirmadoPaciente());
	}
}
