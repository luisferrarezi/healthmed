package br.com.fiap.healthmed.adapter.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.healthmed.core.entity.paciente.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
}
