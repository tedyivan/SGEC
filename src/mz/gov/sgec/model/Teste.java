package mz.gov.sgec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Teste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String descricao;
	
	private Date created_at;
	private Date updated_at;
	
	/*
	 * Relacionamento com InstruendoTeste
	 */
	
	@ManyToOne
	@JoinColumn(name="teste_id")
	private InstruendoTeste instruendoTestes;
	
	/*
	 * Contrutor
	 */
	public Teste() {
		// TODO Auto-generated constructor stub
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public InstruendoTeste getInstruendoTestes() {
		return instruendoTestes;
	}

	public void setInstruendoTestes(InstruendoTeste instruendoTestes) {
		this.instruendoTestes = instruendoTestes;
	}
	@Override
	public String toString() {
		return "Teste [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}


}
