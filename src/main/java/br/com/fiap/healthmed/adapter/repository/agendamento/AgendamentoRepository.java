package br.com.fiap.healthmed.adapter.repository.agendamento;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.healthmed.core.entity.agendamento.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
}
