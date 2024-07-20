package br.com.fiap.healthmed.adapter.repository.medico;

import br.com.fiap.healthmed.core.entity.medico.Medico;

public record MedicoDto(
        	long idMedico,
			String crm,
			String nome,
			int avaliacao,
			int especializacao,	
			long idAutenticacao) {
	
	public MedicoDto(Medico medico) {
		this(medico.getIdMedico(), medico.getCrm(), medico.getNome(), medico.getAvaliacao(),
			 medico.getEspecializacao(), medico.getIdAutenticacao());
	}
}
