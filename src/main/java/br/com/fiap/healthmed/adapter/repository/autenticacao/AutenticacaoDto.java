package br.com.fiap.healthmed.adapter.repository.autenticacao;

import br.com.fiap.healthmed.core.entity.autenticacao.Autenticacao;

public record AutenticacaoDto(
        	long idAutenticacao,
			String login,
			String senha,
			int logado) {
	
	public AutenticacaoDto(Autenticacao autenticacao) {
		this(autenticacao.getIdAutenticacao(), autenticacao.getLogin(), 
			 autenticacao.getSenha(), autenticacao.getLogado());
	}
}
