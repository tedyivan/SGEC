package mz.gov.sgec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Utilizador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String utilizador;
	
	private String senha;
	
	private String email;
    
	private String t‬ipo;
    
   // @OneToOne
    //@JoinColumn(name="funcionario_id")
	
    public Utilizador() {
		// TODO Auto-generated constructor stub
	}
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getT‬ipo() {
		return t‬ipo;
	}
	public void setT‬ipo(String t‬ipo) {
		this.t‬ipo = t‬ipo;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Utilizador [id=" + id + ", Utilizador =" + utilizador + ", senha=" + senha + ", email=" + email
				+ ", t‬ipo=" + t‬ipo + "]";
	}
}
