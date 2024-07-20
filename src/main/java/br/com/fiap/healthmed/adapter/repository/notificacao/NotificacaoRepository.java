package br.com.fiap.healthmed.adapter.repository.notificacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.healthmed.core.entity.notificacao.Notificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long>{
}
