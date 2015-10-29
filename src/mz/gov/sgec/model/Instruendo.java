/**
 * 
 */
package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author laice
 *
 */
@Entity
public class Instruendo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long instruendo_id;
	
	private String nome;
	private String bi;
	private Date data_nascimento;
	private String naturalidade;
	private String estado_civil;
	private double altura;
	private Date created_at;
	private Date updated_at;
	
	public Instruendo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Instruendo(String nome, String bi, Date data_nascimento, String naturalidade, String estado_civil,
			double altura) {
		super();
		this.nome = nome;
		this.bi = bi;
		this.data_nascimento = data_nascimento;
		this.naturalidade = naturalidade;
		this.estado_civil = estado_civil;
		this.altura = altura;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBi() {
		return bi;
	}
	public void setBi(String bi) {
		this.bi = bi;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public long getInstruendo_id() {
		return instruendo_id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}


	@Override
	public String toString() {
		return "Instruendo [instruendo_id=" + instruendo_id + ", nome=" + nome + ", bi=" + bi + ", data_nascimento="
				+ data_nascimento + ", naturalidade=" + naturalidade + ", estado_civil=" + estado_civil + ", altura="
				+ altura + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
}
