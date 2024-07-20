package br.com.fiap.healthmed.adapter.repository.medico;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.healthmed.core.entity.medico.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
}
