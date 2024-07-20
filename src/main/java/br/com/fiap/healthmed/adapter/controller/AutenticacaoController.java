package br.com.fiap.healthmed.adapter.controller;

import br.com.fiap.healthmed.adapter.repository.autenticacao.AutenticacaoDto;

public interface AutenticacaoController {	
	public AutenticacaoDto detalhar(Long idAutenticacao);	
	public void login(String login, String senha);
	public void logout(Long idAutenticacao);
}
