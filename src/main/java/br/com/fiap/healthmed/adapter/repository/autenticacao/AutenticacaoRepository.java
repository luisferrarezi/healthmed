package br.com.fiap.healthmed.adapter.repository.autenticacao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.healthmed.core.entity.autenticacao.Autenticacao;

public interface AutenticacaoRepository extends JpaRepository<Autenticacao, Long>{
    
    @Query(value = "SELECT * FROM autenticacao WHERE login = :login", nativeQuery = true)
    Optional<Autenticacao> loadAutenticacaoByLogin(@Param("login") String login);
}
