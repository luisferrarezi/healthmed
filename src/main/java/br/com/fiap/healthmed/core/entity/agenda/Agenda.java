package br.com.fiap.healthmed.core.entity.agenda;

import br.com.fiap.healthmed.adapter.repository.agenda.AgendaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Agenda")
@Table(name = "AGENDA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idAgenda")
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAgenda;

	@NotNull
	private Long idMedico;

	@NotBlank
	@Size(min=10, max=10)
	private String data;
	
	@NotBlank
	@Size(min=5, max=5)
	private String hora;

	public void atualizar(AgendaDto agenda) {
		validaMedico(agenda.idMedico());
		validaData(agenda.data());
		validaHora(agenda.hora());
	}	
	
	private void validaMedico(Long idMedico) {
		if (idMedico != null) {
			this.idMedico = idMedico;
		}				
	}
	
	private void validaData(String data) {
		if (data != null) {
			this.data = data;
		}				
	}	
	
	private void validaHora(String hora) {
		if (hora != null) {
			this.hora = hora;
		}				
	}
}
