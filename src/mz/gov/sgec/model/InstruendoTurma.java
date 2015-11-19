package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class InstruendoTurma {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Date data_inicio;
	private Date data_fim;
	private Date created_at;
	private Date updated_at;
	
	/*
	 * Relacionamento com Instruendo atraves de Matricula
	 * */
	@ManyToOne
	@JoinColumn(name="matricula_id")
	private Matricula matricula;

	/*
	 * Relacionamento com Turma
	 * */
	/*@ManyToOne
	@JoinColumn(name="instruendo_turma_id")
	private Instruendo inst_turma;
	*/
	public InstruendoTurma() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
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

	@Override
	public String toString() {
		return "InstruendoTurma [id=" + id + ", data_inicio=" + data_inicio + ", data_fim=" + data_fim + ", created_at="
				+ created_at + ", updated_at=" + updated_at + "]";
	}
}
