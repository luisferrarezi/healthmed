package br.com.fiap.healthmed.core.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.healthmed.adapter.controller.AutenticacaoController;
import br.com.fiap.healthmed.adapter.repository.autenticacao.AutenticacaoRepository;
import br.com.fiap.healthmed.adapter.repository.autenticacao.ResponseDTO;
import br.com.fiap.healthmed.core.entity.autenticacao.Autenticacao;
import br.com.fiap.healthmed.infra.security.TokenService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AutenticacaoService implements AutenticacaoController {

    private final AutenticacaoRepository repository;
   	private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AutenticacaoService(AutenticacaoRepository repository, PasswordEncoder passwordEncoder, TokenService tokenService){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
		this.tokenService = tokenService;
    }

    @Override
    public ResponseDTO login(String login, String senha) {
        Autenticacao autenticacao = repository.loadAutenticacaoByLogin(login).orElseThrow(EntityNotFoundException::new);

        if(passwordEncoder.matches(senha, autenticacao.getSenha())) {
            String token = this.tokenService.generateToken(autenticacao);
            return new ResponseDTO(autenticacao.getLogin(), token);
        }

        return null;
    }
}
