package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MaterialAlocacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Date data_alocacao;
	private Date data_saida;
	private boolean estado;
	private Date created_at;
	private Date updated_at;
	
	/*
	 * Relacionamento com Turma
	 */
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	private Turma turma;
	
	/*
	 * Relacionamento com Material
	 */
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;
	
	public MaterialAlocacao() {
		// TODO Auto-generated constructor stub
	}

	public Date getData_alocacao() {
		return data_alocacao;
	}

	public void setData_alocacao(Date data_alocacao) {
		this.data_alocacao = data_alocacao;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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
	
	public long getId() {
		return id;
		
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "MaterialAlocacao [id=" + id + ", data_alocacao=" + data_alocacao + ", data_saida=" + data_saida
				+ ", estado=" + estado + ", created_at=" + created_at + ", updated_at=" + updated_at + ", turma="
				+ turma + ", material=" + material + "]";
	}

	
	
}
