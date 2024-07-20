package br.com.fiap.healthmed.adapter.controller;

import br.com.fiap.healthmed.adapter.repository.autenticacao.AutenticacaoDto;

public interface AutenticacaoController {	
	public AutenticacaoDto detalhar(Long idAutenticacao);	
	public AutenticacaoDto cadastrar(AutenticacaoDto dto);	
	public AutenticacaoDto alterar(Long idAutenticacao, AutenticacaoDto dto);
	public void excluir(Long idAutenticacao);
}
