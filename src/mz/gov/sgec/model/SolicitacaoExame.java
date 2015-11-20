package mz.gov.sgec.model;

import java.util.Date;

public class SolicitacaoExame {
	private long id;
	private Date data_exame;
	private double nota;
	private String aproveitamento;
	
	private Date created_at;
	private Date updated_at;
	
	/*
	 * Relacionamento com Matricula
	 */
	private Matricula matricula;
	
	/*
	 * Relacionmerto com Tipo de Exame
	 */
	private Exame exame;
	
	public SolicitacaoExame() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData_exame() {
		return data_exame;
	}

	public void setData_exame(Date data_exame) {
		this.data_exame = data_exame;
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

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	@Override
	public String toString() {
		return "SolicitacaoExame [id=" + id + ", data_exame=" + data_exame + ", nota=" + nota + ", aproveitamento="
				+ aproveitamento + ", created_at=" + created_at + ", updated_at=" + updated_at + ", matricula="
				+ matricula + ", exame=" + exame + "]";
	}
}