package br.com.fiap.healthmed.adapter.repository.autenticacao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.healthmed.core.entity.autenticacao.Autenticacao;

public interface AutenticacaoRepository extends JpaRepository<Autenticacao, Long>{
}
