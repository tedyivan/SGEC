package mz.gov.sgec.model;

import java.util.Date;

public class Teste {
	private long id;
	private String nome;
	private String descricao;
	
	private Date created_at;
	private Date updated_at;
	
	/*
	 * Relacionamento com InstruendoTeste
	 */
	private SolicitacaoExame solicitacaoExame;
	
	/*
	 * Contrutor
	 */
	public Teste() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public SolicitacaoExame getSolicitacaoExame() {
		return solicitacaoExame;
	}

	public void setSolicitacaoExame(SolicitacaoExame solicitacaoExame) {
		this.solicitacaoExame = solicitacaoExame;
	}

	@Override
	public String toString() {
		return "Teste [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
}
