package br.com.fiap.healthmed.core.entity.medico;

import br.com.fiap.healthmed.adapter.repository.medico.MedicoDto;
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

@Entity(name = "Medico")
@Table(name = "MEDICO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idMedico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMedico;

	@NotBlank
	@Size(max=13, min=13)
	private String crm;
	
	@NotBlank
	@Size(max=60)
	private String nome;
	
	@NotNull	
	private int avaliacao;

	@NotNull	
	private int especializacao;	

	@NotNull
	private long idAutenticacao;

	public void atualizar(MedicoDto medico) {
		validaNome(medico.nome());
		validaCrm(medico.crm());
		validaAvaliacao(medico.avaliacao());
		validaEspecializacao(medico.especializacao());
		validaIdAutenticacao(medico.idAutenticacao());
	}	
	
	private void validaNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}				
	}
	
	private void validaCrm(String crm) {
		if (crm != null) {
			this.crm = crm;
		}				
	}	
	
	private void validaAvaliacao(Integer avaliacao) {
		if (avaliacao != null) {
			this.avaliacao = avaliacao;
		}				
	}	

	private void validaEspecializacao(Integer especializacao) {
		if (especializacao != null) {
			this.especializacao = especializacao;
		}				
	}		

	private void validaIdAutenticacao(Long idAutenticacao) {
		if (idAutenticacao != null) {
			this.idAutenticacao = idAutenticacao;
		}				
	}	
}
