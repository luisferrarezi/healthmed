package br.com.fiap.healthmed.core.service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.healthmed.adapter.controller.AgendaController;
import br.com.fiap.healthmed.adapter.repository.agenda.AgendaDto;
import br.com.fiap.healthmed.adapter.repository.agenda.AgendaRepository;
import br.com.fiap.healthmed.core.entity.agenda.Agenda;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class AgendaService implements AgendaController {

    private final AgendaRepository repository;

    public AgendaService(AgendaRepository repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public void criarAgenda(String data, String horaPrimeiraConsulta, String horaUltimaConsulta, 
                            Long idMedico, int tempoConsulta) {

        LocalTime hora = LocalTime.of(Integer.parseInt(horaPrimeiraConsulta.substring(0, 2)), 
                                      Integer.parseInt(horaPrimeiraConsulta.substring(3, 5)));
        LocalTime horaFinal = LocalTime.of(Integer.parseInt(horaUltimaConsulta.substring(0, 2)), 
                                           Integer.parseInt(horaUltimaConsulta.substring(3, 5)));
        while(hora.isBefore(horaFinal) || hora.equals(horaFinal)){
            Agenda agenda = new Agenda();
            agenda.setData(data);
            agenda.setHora(hora.toString());
            agenda.setIdMedico(idMedico);

            repository.save(agenda);

            hora = hora.plusMinutes(tempoConsulta);
        }
    }

    @Override
    public List<AgendaDto> consultaByMedico(Long idMedico) {
		List<Agenda> listAgenda = repository.findByMedico(idMedico);
		
		return listAgenda.stream().map(AgendaDto::new).collect(Collectors.toList());
    }

    @Override
    public AgendaDto detalhar(Long idAgenda) {
		Agenda agenda = repository.findById(idAgenda).orElseThrow(EntityNotFoundException::new);

        return new AgendaDto(agenda);
    }

    @Override
    @Transactional    
    public AgendaDto cadastrar(AgendaDto dto) {
		Agenda agenda = new Agenda();
		agenda.atualizar(dto);
		repository.save(agenda);

		return new AgendaDto(agenda);
    }

    @Override
    @Transactional    
    public AgendaDto alterar(Long idAgenda, AgendaDto dto) {
		Agenda agenda = repository.findById(idAgenda).orElseThrow(EntityNotFoundException::new);
		agenda.atualizar(dto);
		
		return new AgendaDto(agenda);
    }

    @Override
    @Transactional    
    public void excluir(Long idAgenda) {		
		repository.deleteById(idAgenda);
    }
}
