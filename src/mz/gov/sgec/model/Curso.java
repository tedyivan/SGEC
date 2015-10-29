package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long curso_id;
	
	private String nome;
	private String descticao;
	private int duracao;
	private boolean existe;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public Curso(String nome, String descticao, int duracao, boolean existe) {
		super();
		this.nome = nome;
		this.descticao = descticao;
		this.duracao = duracao;
		this.existe = existe;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescticao() {
		return descticao;
	}

	public void setDescticao(String descticao) {
		this.descticao = descticao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public long getCurso_id() {
		return curso_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	@Override
	public String toString() {
		return "Curso [curso_id=" + curso_id + ", nome=" + nome + ", descticao=" + descticao + ", duracao=" + duracao
				+ ", existe=" + existe + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
}
