package mz.gov.sgec.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Presenca {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int nr_faltas;
	private int nr_presencas;
	private Date data_inicio;
	private Date data_fim;
	
	private Date created_at;
	private Date updated_at;
	
	public Presenca() {
		// TODO Auto-generated constructor stub
	}
}