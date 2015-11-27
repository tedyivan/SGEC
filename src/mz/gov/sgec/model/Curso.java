package mz.gov.sgec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nome;
	private String descticao;
	private int duracao;
	private boolean existe;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	@ManyToOne
	@JoinColumn(name="curso_preco_id")
	private CursoPreco curso_preco;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="matricula_curso_id")
	private List <Matricula> matricula = new ArrayList <Matricula> ();
	
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

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", descticao=" + descticao + ", duracao=" + duracao + ", existe="
				+ existe + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
}
