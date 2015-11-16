/**
 * 
 */
package mz.gov.sgec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 
 *
 */
@Entity
public class Instruendo {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String nome_pai;
	private String nome_mae;
	private String apelido;
	private String apelido_pai;
	private String apelido_mae;
	private String residencia;
	private String bi;
	private String genero;
	private Date validade_bi;
	private String tipo_carta;
	private String telefone;
	private String codigo_barra;
	private Date data_nascimento;
	private String naturalidade;
	private String estado_civil;
	private double altura;
	private Date created_at;
	private Date updated_at;
	
	@OneToMany
	@JoinColumn(name = "matricula_id")
	private List <Matricula> lista = new ArrayList <Matricula> ();
	
	public Instruendo() {
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

	public String getNome_pai() {
		return nome_pai;
	}

	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}

	public String getNome_mae() {
		return nome_mae;
	}

	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getApelido_pai() {
		return apelido_pai;
	}

	public void setApelido_pai(String apelido_pai) {
		this.apelido_pai = apelido_pai;
	}

	public String getApelido_mae() {
		return apelido_mae;
	}

	public void setApelido_mae(String apelido_mae) {
		this.apelido_mae = apelido_mae;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getBi() {
		return bi;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getValidade_bi() {
		return validade_bi;
	}

	public void setValidade_bi(Date validade_bi) {
		this.validade_bi = validade_bi;
	}

	public String getTipo_carta() {
		return tipo_carta;
	}

	public void setTipo_carta(String tipo_carta) {
		this.tipo_carta = tipo_carta;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCodigo_barra() {
		return codigo_barra;
	}

	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
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

	public List<Matricula> getLista() {
		return lista;
	}

	public void setLista(List<Matricula> lista) {
		this.lista = lista;
	}	
	
	@Override
	public String toString() {
		return nome;
	}
}