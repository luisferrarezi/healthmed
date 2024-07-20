package br.com.fiap.healthmed.core.entity.paciente;

import br.com.fiap.healthmed.adapter.repository.paciente.PacienteDto;
import br.com.fiap.healthmed.core.annotation.Cpf;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Paciente")
@Table(name = "PACIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idPaciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPaciente;

	@Cpf
	@Size(max=11, min=11)
	private String cpf;
	
	@NotBlank
	@Size(max=60)
	private String nome;
	
	@NotBlank
	@Email
	@Size(max=60)
	private String email;

	@NotNull
	private long idAutenticacao;

	public void atualizar(PacienteDto paciente) {
		validaNome(paciente.nome());
		validaEmail(paciente.email());
		validaCpf(paciente.cpf());
		validaIdAutenticacao(paciente.idAutenticacao());
	}
	
	private void validaNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}				
	}
	
	private void validaEmail(String email) {
		if (email != null) {
			this.email = email;
		}				
	}

	private void validaCpf(String cpf) {
		if (cpf != null) {
			this.cpf = cpf;
		}				
	}
	
	private void validaIdAutenticacao(Long idAutenticacao) {
		if (idAutenticacao != null) {
			this.idAutenticacao = idAutenticacao;
		}				
	}	
}
