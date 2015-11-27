package mz.gov.sgec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Assunto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	private String mesage;
	
	
	@OneToMany
	@JoinColumn(name= "assunto_id")
	private List<Notificacao> notificacaos= new ArrayList<>();
	
	public Assunto(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}

	@Override
	public String toString() {
		return "Assunto [id=" + id + ", nome=" + nome + ", mesage=" + mesage + "]";
	}
	
	
	
	
}
