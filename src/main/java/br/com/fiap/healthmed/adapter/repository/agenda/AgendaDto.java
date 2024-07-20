package br.com.fiap.healthmed.adapter.repository.agenda;

import br.com.fiap.healthmed.core.entity.agenda.Agenda;

public record AgendaDto(
        		long idAgenda,
				Long idMedico,
				String data,
				String hora) {
	
	public AgendaDto(Agenda agenda) {
		this(agenda.getIdAgenda(), agenda.getIdMedico(), agenda.getData(), agenda.getHora());
	}
}
