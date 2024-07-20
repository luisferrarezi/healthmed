package br.com.fiap.healthmed.core.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.fiap.healthmed.adapter.controller.AutenticacaoController;
import br.com.fiap.healthmed.adapter.repository.autenticacao.AutenticacaoDto;
import br.com.fiap.healthmed.adapter.repository.autenticacao.AutenticacaoRepository;
import br.com.fiap.healthmed.core.entity.autenticacao.Autenticacao;
import br.com.fiap.healthmed.core.enums.SimOuNao;
import br.com.fiap.healthmed.core.exception.BusinessException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class AutenticacaoService implements AutenticacaoController {

    private final AutenticacaoRepository repository;

    public AutenticacaoService(AutenticacaoRepository repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public AutenticacaoDto detalhar(Long idAutenticacao) {
   		Autenticacao autenticacao = repository.findById(idAutenticacao).orElseThrow(EntityNotFoundException::new);

        return new AutenticacaoDto(autenticacao);
    }

    @Override
    @Transactional
    public void login(String login, String senha) {
        Autenticacao autenticacao = repository.login(login, senha);

        if (autenticacao != null){
            autenticacao.setLogado(SimOuNao.SIM.ordinal());

            this.repository.save(autenticacao);
        } else {
            throw new BusinessException("Usuário não localizado!", HttpStatus.NOT_FOUND, "Login");
        }
    }

    @Override
    @Transactional
    public void logout(Long idAutenticacao) {
        Autenticacao autenticacao = repository.findById(idAutenticacao).orElseThrow(EntityNotFoundException::new);
        autenticacao.setLogado(SimOuNao.NAO.ordinal());

        this.repository.save(autenticacao);
    }
}
