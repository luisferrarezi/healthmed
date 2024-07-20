package br.com.fiap.healthmed.adapter.repository.agenda;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.healthmed.core.entity.agenda.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
}
