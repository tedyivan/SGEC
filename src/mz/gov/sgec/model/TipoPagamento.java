package mz.gov.sgec.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TipoPagamento {
	private long id;
	private String nome;
	private String descricao;
	private boolean existe;
	
	private Date created_at;
	private Date updated_at;	
	
	/*
	 * Relacionamento com Pagamento
	 */
	private List<Pagamento> pagamentos = new ArrayList<>();
	
	/*
	 * Construtor
	 */
	public TipoPagamento() {
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

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
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
	
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	@Override
	public String toString() {
		return "TipoPagamento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", existe=" + existe
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
}
