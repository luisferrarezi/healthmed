package br.com.fiap.healthmed.adapter.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.fiap.healthmed.adapter.repository.medico.MedicoDto;

public interface MedicoController {	
	public Page<MedicoDto> consultaPaginada(Pageable paginacao);
	public MedicoDto detalhar(Long idMedico);	
	public MedicoDto cadastrar(MedicoDto dto);	
	public MedicoDto alterar(Long idMedico, MedicoDto dto);
	public void excluir(Long idMedico);
}
