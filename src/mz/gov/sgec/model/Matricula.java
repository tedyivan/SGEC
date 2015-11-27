package mz.gov.sgec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double valor_curso;
	private Date data_inicio;
	private Date data_fim;
	private Date created_at;
	private Date updated_at;
	
	@ManyToOne
	@JoinColumn(name="matricula_id")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="matricula_teste_id")
	private InstruendoTeste instruendo_teste;
	
	@ManyToOne
	@JoinColumn(name="matricula_solicitacao_id")
	private SolicitacaoExame solicitacao;
	
	@ManyToOne
	@JoinColumn(name="matricula_instruendo_id")
	private Instruendo instruendo;
	
	
	@ManyToOne
	@JoinColumn(name="matricula_curso_id")
	private Curso curso;
	
	public Matricula() {
		// TODO Auto-generated constructor stub
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

	

	
	


	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	
}