package mz.gov.sgec.controller;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import java.util.Date;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;

import mz.gov.sgec.dao.MaterialDAO;
import mz.gov.sgec.dao.MaterialGeralDAO;
import mz.gov.sgec.model.Material;
import mz.gov.sgec.model.MaterialGeral;

public class MaterialgeralController extends GenericForwardComposer {
	private Textbox txt_classe, txt_marca,txt_quantidade,
			txt_descricao,txt_garantia, txt_tipo,
			txt_tipocombustivel,txt_preco,txt_designacao;
	
	private Label txt_tipomat;
	
	private Datebox dt_aquisicao;
	private int quant;
	
	
	
	public void onClick$btn_reg(Event e){
		Material mat = new Material();
		
		MaterialGeral matgeral= new MaterialGeral();
		Date dt_aqui=dt_aquisicao.getValue();
		quant = Integer.parseInt(txt_quantidade.getValue());
		mat.setNome(txt_designacao.getValue());
		
		
		mat.setData_aquisicao(dt_aqui);
		mat.setCreated_at(new Date());
		mat.setPreco(Double.parseDouble(txt_preco.getValue()));
		mat.setDescricao(txt_descricao.getValue());
		mat.setUpdated_at(new Date());
		mat.setExiste(true);
		MaterialDAO materialDao=new MaterialDAO();
		materialDao.create(mat);
		
		
		matgeral.setTipo_mat(Integer.parseInt(txt_tipomat.getValue()));
		
		
				
		matgeral.setCreated_at(new Date());
		matgeral.setUpdated_at(new Date());
		matgeral.setMaterial(mat);
		MaterialGeralDAO matgeralDAO = new MaterialGeralDAO();
		
		matgeralDAO.createMaterial(matgeral, quant);
		
		
		Clients.showNotification("Material Registado com sucesso");
		
		
	}
	
	
	
	
	
	
}
