package br.com.fiap.healthmed.adapter.repository.paciente;

import br.com.fiap.healthmed.core.entity.paciente.Paciente;

public record PacienteDto(
        Long idPaciente,
        String cpf, 
		String nome, 
		String email,
		Long idAutenticacao) {
	
	public PacienteDto(Paciente paciente) {
		this(paciente.getIdPaciente(), paciente.getCpf(), paciente.getNome(), paciente.getEmail(), paciente.getIdAutenticacao());
	}
}
