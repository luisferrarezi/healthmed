package br.com.fiap.healthmed.adapter.controller;

import br.com.fiap.healthmed.adapter.repository.notificacao.NotificacaoDto;

public interface NotificacaoController {	
	public NotificacaoDto detalhar(Long idNotificacao);	
	public NotificacaoDto cadastrar(NotificacaoDto dto);	
	public NotificacaoDto alterar(Long idNotificacao, NotificacaoDto dto);
	public void excluir(Long idNotificacao);
}
