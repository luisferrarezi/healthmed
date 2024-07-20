package br.com.fiap.healthmed.core.entity.agendamento;

import br.com.fiap.healthmed.adapter.repository.agendamento.AgendamentoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Agendamento")
@Table(name = "AGENDAMENTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idAgendamento")
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAgendamento;

	@NotNull
	private Long idAgenda;

	@NotNull
	private Long idPaciente;
	
	@NotNull
	private Integer confirmadoMedico;	

	@NotNull
	private Integer confirmadoPaciente;	

	public void atualizar(AgendamentoDto agendamento) {
		validaAgenda(agendamento.idAgenda());
		validaPaciente(agendamento.idPaciente());
		validaConfirmadoMedico(agendamento.confirmadoMedico());
		validaConfirmadoPaciente(agendamento.confirmadoPaciente());
	}	
	
	private void validaAgenda(Long idAgenda) {
		if (idAgenda != null) {
			this.idAgenda = idAgenda;
		}				
	}
	
	private void validaPaciente(Long idPaciente) {
		if (idPaciente != null) {
			this.idPaciente = idPaciente;
		}				
	}	
	
	private void validaConfirmadoMedico(Integer confirmadoMedico) {
		if (confirmadoMedico != null) {
			this.confirmadoMedico = confirmadoMedico;
		}				
	}

	private void validaConfirmadoPaciente(Integer confirmadoPaciente) {
		if (confirmadoPaciente != null) {
			this.confirmadoPaciente = confirmadoPaciente;
		}				
	}	
}
