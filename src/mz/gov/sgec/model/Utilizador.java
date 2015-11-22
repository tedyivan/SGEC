package mz.gov.sgec.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Utilizador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String utilizador;
	
	private String senha;
	
	private String email;
    
	private String tipo;
	
	@OneToMany
	@JoinColumn(name="notificacao_id")
	private List<Notificacao> notificacao= new ArrayList <Notificacao>();
    
   
    public Utilizador() {
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	
	
	
	public String getUtilizador() {
		return utilizador;
	}


	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}


	@Override
	public String toString() {
		return "Utilizador [id=" + id + ", utilizador=" + utilizador + ", senha=" + senha + ", email=" + email
				+ ", tipo=" + tipo + "]";
	}


	

	
    
		
}