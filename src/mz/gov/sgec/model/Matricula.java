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
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double valor_curso;
	private Date data_inicio;
	private Date data_fim;
	private Date created_at;
	private Date updated_at;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="matricula_id")
	private List<Pagamento> pagamentos = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="matricula_id")
	private List<Instruendo> instruendos = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="matricula_id")
	private List<SolicitacaoExame> solicitacaoExames = new ArrayList<>();
	
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

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public List<Instruendo> getInstruendos() {
		return instruendos;
	}

	public void setInstruendos(List<Instruendo> instruendos) {
		this.instruendos = instruendos;
	}

	public List<SolicitacaoExame> getSolicitacaoExames() {
		return solicitacaoExames;
	}

	public void setSolicitacaoExames(List<SolicitacaoExame> solicitacaoExames) {
		this.solicitacaoExames = solicitacaoExames;
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