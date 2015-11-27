package mz.gov.sgec.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
    private String nome;
    private String apelido;
    private String nr_bi;
    private String nuit;
    private String contacto;
    private String categoria;
    private String email;
    private Date data_nascimento;
  
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
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getNr_bi() {
		return nr_bi;
	}
	public void setNr_bi(String nr_bi) {
		this.nr_bi = nr_bi;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getNuit() {
		return nuit;
	}
	public void setNuit(String nuit) {
		this.nuit = nuit;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", nr_bi=" + nr_bi + ", nuit="
				+ nuit + ", contacto=" + contacto + ", categoria=" + categoria + ", email=" + email
				+ ", data_nascimento=" + data_nascimento + "]";
	}
	
	
	
	
	
}