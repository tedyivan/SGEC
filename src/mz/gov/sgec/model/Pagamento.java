package mz.gov.sgec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double valor;
	private Date created_at;
	private Date updated_at;
	
	/*
	 * Relacionamento com Tipo de Pagamento
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "pagamento_id")
	private List<TipoPagamento> pagamento_tipo = new ArrayList <TipoPagamento> ();
	/*
	 * Relacionamento com Matricula
	 */
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="matricula_id")
	private List<Matricula> matricula = new ArrayList<Matricula>();
	
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
	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		return "TipoPagamento [id=" + id + ", valor=" + valor + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}

	
}
