package mz.gov.sgec.controller;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.List;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import java.util.Date;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;


import mz.gov.sgec.dao.MaterialDAO;
import mz.gov.sgec.dao.MaterialGeralDAO;
import mz.gov.sgec.dao.TurmaDAO;
import mz.gov.sgec.dao.MaterialAlocacaoDAO;
import mz.gov.sgec.model.MaterialAlocacao;
import mz.gov.sgec.model.Material;
import mz.gov.sgec.model.MaterialGeral;
import mz.gov.sgec.model.Turma;


public class MaterialgeralController extends GenericForwardComposer {
	private Textbox txt_classe, txt_marca,txt_quantidade,
			txt_descricao,txt_garantia, txt_tipo,
			txt_tipocombustivel,txt_preco,txt_designacao;
	private long turma_id;
	private Label txt_tipomat;
	
	private Datebox dt_aquisicao;
	private int quant;
	private TurmaDAO turmaDao = new TurmaDAO();
	private Turma t ;
	private MaterialAlocacaoDAO matAlDao= new MaterialAlocacaoDAO();
	private MaterialGeral matgeral;
	private MaterialDAO materialDao;
	private MaterialGeralDAO materialGDAO = new MaterialGeralDAO();
	
	private Div wind_veicle;
	private Window window,wd;
	private Div wind_teorico;
	
	public void onClick$btn_reg(Event e){
		Material mat = new Material();
		MaterialAlocacao matAlo= new MaterialAlocacao();
		matgeral= new MaterialGeral();
		Date dt_aqui=dt_aquisicao.getValue();
		quant = Integer.parseInt(txt_quantidade.getValue());
		mat.setNome(txt_designacao.getValue());
		
		
		mat.setData_aquisicao(dt_aqui);
		mat.setCreated_at(new Date());
		mat.setPreco(Double.parseDouble(txt_preco.getValue()));
		mat.setDescricao(txt_descricao.getValue());
		mat.setUpdated_at(new Date());
		mat.setExiste(true);
		materialDao=new MaterialDAO();
		materialDao.create(mat);
		
		
		matgeral.setTipo_mat(Integer.parseInt(txt_tipomat.getValue()));
		
		
				
		matgeral.setCreated_at(new Date());
		matgeral.setUpdated_at(new Date());
		matgeral.setMaterial(mat);
		MaterialGeralDAO matgeralDAO = new MaterialGeralDAO();
		
		//Eliminando a parte de multiplos materiais. Fica pra o futuro
		//matgeralDAO.createMaterial(matgeral, quant);
		matgeralDAO.create(matgeral);
		matAlo.setMaterial(mat);
		matAlo.setTurma(t);
		
		matAlDao.create(matAlo);
		
		Clients.showNotification("Material Registado com sucesso");
		
		
	}
	
	public void onClick$btn_aloc_turma(Event e){
		 window = (Window) Executions.createComponents("turma_listar_alocar.zul", null,null);
		 window.doModal();
		 
		//Executions.createComponents("registo_material_teorico.zul", null,null);
	}
	public void onClick$linha(ForwardEvent e) {
		
		t = (Turma)((Listitem) e.getOrigin().getTarget()).getValue();
		
		turma_id = t.getId();
		//window.detach();
        //window =(Window) Executions.getCurrent().getDesktop();
        //window.detach();
		//Clients.showNotification(t.toString());
		
	}
	
	public void onClick$btn_veic(){
		wind_veicle.setVisible(true);
		wind_teorico.setVisible(false);
	}
	
	public void onClick$btn_teoric(){
		wind_veicle.setVisible(false);
		wind_teorico.setVisible(true);
	}
	
	public void onClick$btn_pratico(){
		wind_veicle.setVisible(false);
		wind_teorico.setVisible(true);
	}
	
	

	public List <Turma> getTurmas(){
		return turmaDao.findAll();
	}
	
	public List <MaterialGeral> getMaterialGerais(){
		MaterialGeralDAO mtgeralDAO = new MaterialGeralDAO();
		List<MaterialGeral> mtger =mtgeralDAO.findAll();
		return mtger;
	}
	
}
