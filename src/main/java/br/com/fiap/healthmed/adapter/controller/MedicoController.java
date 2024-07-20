package br.com.fiap.healthmed.adapter.controller;

import java.util.List;

import br.com.fiap.healthmed.adapter.repository.medico.MedicoDto;
import br.com.fiap.healthmed.core.enums.Especializacao;

public interface MedicoController {	
	public List<MedicoDto> consultar(String nome, Especializacao especializacao, long idAutenticacao);
	public MedicoDto detalhar(Long idMedico);	
	public MedicoDto cadastrar(MedicoDto dto);	
	public MedicoDto alterar(Long idMedico, MedicoDto dto);
	public void excluir(Long idMedico);
}
