package br.com.fiap.healthmed.adapter.controller;

public interface AutenticacaoController {	
	public boolean isAutenticado(Long idAutenticacao);	
	public void login(String login, String senha);
	public void logout(Long idAutenticacao);
}
