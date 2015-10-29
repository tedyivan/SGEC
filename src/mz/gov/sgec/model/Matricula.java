package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long matricula_id;
	
	private double valor_curso;
	private Date data_inicio;
	private Date data_fim;
	private Date created_at;
	private Date updated_at;
	
	@ManyToOne
	@JoinColumn(name="instruendo_id")
	private Instruendo instruendo;
	
	@ManyToOne
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	public Matricula() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Matricula(long matricula_id, double valor_curso, Date data_inicio, Date data_fim) {
		super();
		this.matricula_id = matricula_id;
		this.valor_curso = valor_curso;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}

	public long getMatricula_id() {
		return matricula_id;
	}
	
	public double getValor_curso() {
		return valor_curso;
	}
	public void setValor_curso(double valor_curso) {
		this.valor_curso = valor_curso;
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

	public Date getUpdated_at() {
		return updated_at;
	}

	

	
	public Instruendo getInstruendo() {
		return instruendo;
	}


	public void setInstruendo(Instruendo instruendo) {
		this.instruendo = instruendo;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	@Override
	public String toString() {
		return "Matricula [matricula_id=" + matricula_id + ", valor_curso=" + valor_curso + ", data_inicio="
				+ data_inicio + ", data_fim=" + data_fim + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}
	
	
}
