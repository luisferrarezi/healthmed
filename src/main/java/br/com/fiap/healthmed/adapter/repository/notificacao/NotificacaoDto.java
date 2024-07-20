package br.com.fiap.healthmed.adapter.repository.notificacao;

import br.com.fiap.healthmed.core.entity.notificacao.Notificacao;

public record NotificacaoDto(
        	long idNotificacao,
			String mensagem,
			long idAutenticacao) {
	
	public NotificacaoDto(Notificacao notificacao) {
		this(notificacao.getIdAutenticacao(), notificacao.getMensagem(), notificacao.getIdAutenticacao());
	}
}
