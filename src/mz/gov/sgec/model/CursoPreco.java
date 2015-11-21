package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CursoPreco {
	@Id
	private long id;
	private double preco;
	private Date created_at;
	private Date updated_at;
	
	/*
	 * Relacionamento com Curso
	 */
	@OneToMany()
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	/*
	 * Construtor
	 */
	public CursoPreco() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "CursoPreco [id=" + id + ", preco=" + preco + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", curso=" + curso + "]";
	}
}
