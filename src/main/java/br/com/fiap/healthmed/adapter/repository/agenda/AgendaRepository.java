package br.com.fiap.healthmed.adapter.repository.agenda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.healthmed.core.entity.agenda.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{

	@Query(value = "SELECT * FROM agenda WHERE id_medico = :idMedico", nativeQuery = true)
	List<Agenda> findByMedico(@Param("idMedico") Long idMedico);
}
