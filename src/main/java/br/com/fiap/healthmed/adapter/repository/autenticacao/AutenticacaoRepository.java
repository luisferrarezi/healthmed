package br.com.fiap.healthmed.adapter.repository.autenticacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.healthmed.core.entity.autenticacao.Autenticacao;

public interface AutenticacaoRepository extends JpaRepository<Autenticacao, Long>{
    
    @Query(value = "SELECT * FROM autenticacao WHERE login = :login AND senha = :senha", nativeQuery = true)
	Autenticacao login(@Param("login") String login,
                       @Param("senha") String senha);
}
