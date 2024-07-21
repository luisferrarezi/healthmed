package br.com.fiap.healthmed.infra.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.fiap.healthmed.adapter.repository.autenticacao.AutenticacaoRepository;
import br.com.fiap.healthmed.core.entity.autenticacao.Autenticacao;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final AutenticacaoRepository repository;

    public CustomUserDetailsService(AutenticacaoRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Autenticacao autenticacao = this.repository.loadAutenticacaoByLogin(login)
                                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        return new org.springframework.security.core.userdetails.User(autenticacao.getLogin(), autenticacao.getSenha(), new ArrayList<>());
    }
}
