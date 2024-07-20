package br.com.fiap.healthmed.core.entity.autenticacao;

import br.com.fiap.healthmed.adapter.repository.autenticacao.AutenticacaoDto;
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

@Entity(name = "Autenticacao")
@Table(name = "AUTENTICACAO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idAutenticacao")
public class Autenticacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAutenticacao;

	@NotBlank
	@Size(max=30)
	private String login;
	
	@NotBlank
	@Size(max=60)
	private String senha;
	
	@NotNull	
	private int logado;	

	public void atualizar(AutenticacaoDto autenticacao) {
		validaLogin(autenticacao.login());
		validaSenha(autenticacao.senha());
		validaLogado(autenticacao.logado());
	}	
	
	private void validaLogin(String login) {
		if (login != null) {
			this.login = login;
		}				
	}
	
	private void validaSenha(String senha) {
		if (senha != null) {
			this.senha = senha;
		}				
	}	
	
	private void validaLogado(Integer logado) {
		if (logado != null) {
			this.logado = logado;
		}				
	}
}
