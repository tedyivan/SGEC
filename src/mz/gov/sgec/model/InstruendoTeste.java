package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class InstruendoTeste {
	@Id
	private long id;
	private double nota;
	private String aproveitamento;
	private Date data_criacao;
	
	private Date created_at;
	private Date updated_at;
	
	/*
	 * Relacionemto com Instruendo
	 */
	@OneToMany
	@JoinColumn(name="matricula_id")
	private Matricula matricula;
	
	/*
	 * Relacionamento com Teste
	 */
	
	@OneToMany
	@JoinColumn(name="teste_id")
	private Teste teste;
	
	public InstruendoTeste() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getAproveitamento() {
		return aproveitamento;
	}

	public void setAproveitamento(String aproveitamento) {
		this.aproveitamento = aproveitamento;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
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
	

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Teste getTeste() {
		return teste;
	}

	public void setTeste(Teste teste) {
		this.teste = teste;
	}

	@Override
	public String toString() {
		return "InstruendoTeste [id=" + id + ", nota=" + nota + ", aproveitamento=" + aproveitamento + ", data_criacao="
				+ data_criacao + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
}
