package br.com.fiap.healthmed.core.service;

import org.springframework.stereotype.Service;

import br.com.fiap.healthmed.adapter.controller.AgendamentoController;
import br.com.fiap.healthmed.adapter.repository.agendamento.AgendamentoDto;
import br.com.fiap.healthmed.adapter.repository.agendamento.AgendamentoRepository;
import br.com.fiap.healthmed.core.entity.agendamento.Agendamento;
import br.com.fiap.healthmed.core.enums.SimOuNao;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class AgendamentoService implements AgendamentoController {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository){
        this.repository = repository;
    }

    @Override
    public AgendamentoDto detalhar(Long idAgendamento) {
		Agendamento agendamento = repository.findById(idAgendamento).orElseThrow(EntityNotFoundException::new);

        return new AgendamentoDto(agendamento);
    }

    @Override
    @Transactional    
    public AgendamentoDto cadastrar(AgendamentoDto dto) {
		Agendamento agendamento = new Agendamento();
		agendamento.atualizar(dto);
		repository.save(agendamento);

		return new AgendamentoDto(agendamento);
    }

    @Override
    @Transactional    
    public AgendamentoDto alterar(Long idAgendamento, AgendamentoDto dto) {
		Agendamento agendamento = repository.findById(idAgendamento).orElseThrow(EntityNotFoundException::new);
		agendamento.atualizar(dto);
		
		return new AgendamentoDto(agendamento);
    }

    @Override
    @Transactional    
    public void excluir(Long idAgendamento) {		
  	    repository.deleteById(idAgendamento);
    }

    @Override
    public void aceitar(Long idAgendamento) {
		Agendamento agendamento = repository.findById(idAgendamento).orElseThrow(EntityNotFoundException::new);
        agendamento.setConfirmadoMedico(SimOuNao.SIM.ordinal());
        repository.save(agendamento);
    }

    @Override
    public void recusar(Long idAgendamento) {
        Agendamento agendamento = repository.findById(idAgendamento).orElseThrow(EntityNotFoundException::new);
        agendamento.setConfirmadoMedico(SimOuNao.NAO.ordinal());
        repository.save(agendamento);
    }
}
