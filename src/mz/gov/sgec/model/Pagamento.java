package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pagamento {
	@Id
	private long id;
	private double valor;
	private Date created_at;
	private Date updated_at;
	
	/*
	 * Relacionamento com Tipo de Pagamento
	 */
	@OneToMany
	@JoinColumn(name="tipopagamento_id")
	private TipoPagamento tipoPagamento;
	
	/*
	 * Relacionamento com Matricula
	 */
	
	@OneToMany
	@JoinColumn(name="matricula_id")
	private Matricula matricula;
	
	
	/*
	 * Contrutor 
	 */
	public Pagamento() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	@Override
	public String toString() {
		return "TipoPagamento [id=" + id + ", valor=" + valor + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}
}
