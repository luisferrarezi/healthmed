package br.com.fiap.healthmed.adapter.controller;

import br.com.fiap.healthmed.adapter.repository.autenticacao.ResponseDTO;

public interface AutenticacaoController {
	public ResponseDTO login(String login, String senha);
}
