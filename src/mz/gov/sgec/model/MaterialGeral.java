package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MaterialGeral {
	
	/*Variaveis Na Doc.*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int tipo_mat;
	private Date created_at;
	private Date updated_at;
	
	/*Relacionamento com Material*/
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;
	
	public MaterialGeral() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTipo_mat() {
		return tipo_mat;
	}

	public void setTipo_mat(int tipo_mat) {
		this.tipo_mat = tipo_mat;
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

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "MaterialGeral [id=" + id + ", tipo_mat=" + tipo_mat + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", material=" + material + "]";
	}
}