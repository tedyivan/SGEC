package mz.gov.sgec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Notificacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String mensagem;
	
	@ManyToOne
	@JoinColumn(name="assunto_id")
	private Assunto assunto;
	
	@ManyToOne
	@JoinColumn(name="utilizador_id")
	private Utilizador Utilizador; 
	
	@ManyToOne
	@JoinColumn(name="instruendo_id")
	private Instruendo instruendo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public Utilizador getUtilizador() {
		return Utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		Utilizador = utilizador;
	}

	public Instruendo getInstruendo() {
		return instruendo;
	}

	public void setInstruendo(Instruendo instruendo) {
		this.instruendo = instruendo;
	}

	@Override
	public String toString() {
		return "Notificacao [id=" + id + ", mensagem=" + mensagem + ", assunto=" + assunto + ", Utilizador="
				+ Utilizador + ", instruendo=" + instruendo + "]";
	}
	
	
	
}
