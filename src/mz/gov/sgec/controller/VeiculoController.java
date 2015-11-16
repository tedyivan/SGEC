package mz.gov.sgec.controller;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;

import mz.gov.sgec.dao.MaterialDAO;
import mz.gov.sgec.dao.VeiculoDAO;
import mz.gov.sgec.model.Veiculo;
import mz.gov.sgec.model.Material;

public class VeiculoController extends GenericForwardComposer {
	private Textbox txt_classe, txt_marca,txt_matricula,txt_lotacao,
			txt_pesobruto,txt_descricao,txt_garantia, txt_tipo,
			txt_modelo,txt_tara,txt_tipocombustivel,txt_preco;
	private String txt_designacao = "veiculo" ;
	
	private Datebox dt_aquisicao, dt_fabrico;
	
	private VeiculoDAO veiculoDAO = new VeiculoDAO();
	
	
	public void onClick$btn_reg(Event e){
		Material mat = new Material();
		
		Veiculo vei = new Veiculo();
		
		
		mat.setNome(txt_designacao);
		Date dt_aqui=dt_aquisicao.getValue();
		Date dt_fabri= dt_fabrico.getValue();
		mat.setData_aquisicao(dt_aqui);
		mat.setCreated_at(new Date());
		mat.setPreco(Double.parseDouble(txt_preco.getValue()));
		mat.setDescricao(txt_descricao.getValue());
		mat.setUpdated_at(new Date());
		mat.setExiste(true);
		MaterialDAO materialDao=new MaterialDAO();
		materialDao.create(mat);
		vei.setClasse(txt_classe.getValue());
		vei.setMarca(txt_marca.getValue());
		vei.setModelo(txt_modelo.getValue());
		vei.setMatricula(txt_matricula.getValue());
		vei.setAno_fabrico(dt_fabri);
		vei.setLotacao(txt_lotacao.getValue());
		vei.setTara(txt_tara.getValue());
		vei.setPeso_bruto(Double.parseDouble(txt_pesobruto.getValue()));
		vei.setTipo_combustivel(txt_tipocombustivel.getValue());
		vei.setTipo(txt_tipo.getText());
		
		vei.setCreated_at(new Date());
		vei.setUpdated_at(new Date());
		vei.setMaterial(mat);
		VeiculoDAO veiculoDao= new VeiculoDAO();
		veiculoDao.create(vei);
		Clients.showNotification("veiculo Registado com sucesso");
		
		
	}
	

	
	public List <Veiculo> getVeiculos(){
		return  veiculoDAO.findAll();
	}
	
	
	
}
