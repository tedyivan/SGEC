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
	
	@OneToOne
	@JoinColumn(name="assunto_id")
	private Assunto assunto;
	
	@ManyToOne
	@JoinColumn(name="utilizador_id")
	private Utilizador Utilizador; 
	
	@ManyToOne
	@JoinColumn(name="instruendo_id")
	private Instruendo instruendo;
	
	
	
}
