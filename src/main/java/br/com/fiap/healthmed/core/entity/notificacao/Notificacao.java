package br.com.fiap.healthmed.core.entity.notificacao;

import br.com.fiap.healthmed.adapter.repository.notificacao.NotificacaoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Notificacao")
@Table(name = "NOTIFICACAO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idNotificacao")
public class Notificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idNotificacao;

	@Size(max=100)
	private String mensagem;
	
	@NotNull
	private long idAutenticacao;

	public void atualizar(NotificacaoDto notificacao) {
		validaMensagem(notificacao.mensagem());
		validaIdAutenticacao(notificacao.idAutenticacao());
	}
	
	private void validaMensagem(String mensagem) {
		if (mensagem != null) {
			this.mensagem = mensagem;
		}				
	}
	
	private void validaIdAutenticacao(Long idAutenticacao) {
		if (idAutenticacao != null) {
			this.idAutenticacao = idAutenticacao;
		}				
	}
}
