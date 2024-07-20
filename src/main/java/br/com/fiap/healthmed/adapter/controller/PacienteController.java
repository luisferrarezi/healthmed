package br.com.fiap.healthmed.adapter.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.fiap.healthmed.adapter.repository.paciente.PacienteDto;

public interface PacienteController {	
	public Page<PacienteDto> consultaPaginada(Pageable paginacao);
	public PacienteDto detalhar(Long idPaciente);
	public PacienteDto cadastrar(PacienteDto dto);	
	public PacienteDto alterar(Long idPaciente, PacienteDto dto);
	public void excluir(Long idPaciente);
}
