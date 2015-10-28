package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Veiculo {
	/*Variaveis Na Doc.*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String matricula;
	private String lotacao;
	private Date ano_fabrico;
	private double peso_bruto;
	private String tipo_combustivel;
	private Date created_at;
	private Date updated_at;
	
	/*Variaveis Novos*/
	private String classe;
	private String marca;
	private String tara;
	private String tipo;
	private String modelo;
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/*Relacionamento com Material*/
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;
	
	/*
	 * Contrutor
	 * */
	public Veiculo() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	public Date getAno_fabrico() {
		return ano_fabrico;
	}

	public void setAno_fabrico(Date ano_fafabrico) {
		this.ano_fabrico = ano_fafabrico;
	}

	public double getPeso_bruto() {
		return peso_bruto;
	}

	public void setPeso_bruto(double peso_bruto) {
		this.peso_bruto = peso_bruto;
	}

	public String getTipo_combustivel() {
		return tipo_combustivel;
	}

	public void setTipo_combustivel(String tipo_combustivel) {
		this.tipo_combustivel = tipo_combustivel;
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

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTara() {
		return tara;
	}

	public void setTara(String tara) {
		this.tara = tara;
	}
	
	
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", matricula=" + matricula + ", lotacao=" + lotacao + ", ano_fabrico="
				+ ano_fabrico + ", peso_bruto=" + peso_bruto + ", tipo_combustivel=" + tipo_combustivel
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", classe=" + classe + ", marca="
				+ marca + ", tara=" + tara + ", tipo=" + tipo + ", modelo=" + modelo + ", material=" + material + "]";
	}
}