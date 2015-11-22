package mz.gov.sgec.controller;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.List;
import java.util.Map;

import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;


import mz.gov.sgec.dao.MaterialDAO;
import mz.gov.sgec.dao.MaterialGeralDAO;
import mz.gov.sgec.dao.TurmaDAO;
import mz.gov.sgec.dao.MaterialAlocacaoDAO;
import mz.gov.sgec.model.MaterialAlocacao;
import mz.gov.sgec.model.Instruendo;
import mz.gov.sgec.model.Material;
import mz.gov.sgec.model.MaterialGeral;
import mz.gov.sgec.model.Turma;
import mz.gov.sgec.model.Veiculo;


public class MaterialgeralController extends GenericForwardComposer {
	private Textbox txt_classe, txt_marca,txt_quantidade,
			txt_descricao,txt_garantia, txt_tipo,
			txt_tipocombustivel,txt_preco,txt_designacao;
	private Window wind_turma_aloc;
	private long turma_id;
	private Label txt_tipomat,lb_material_id,lb_created,lb_materialgeral_id;
	private Veiculo veiculo;
	private Datebox dt_aquisicao;
	private Date dt_aqui;
	private int quant;
	private TurmaDAO turmaDao = new TurmaDAO();
	private Turma t;
	private MaterialAlocacaoDAO matAlDao;
	private MaterialGeral matgeral;
	private MaterialDAO materialDao;
	private MaterialGeralDAO materialGDAO;
	private Material mat;
	private MaterialAlocacao matAlo;
	
	private Div wind_veicle;
	private Window window,wd;
	private Div wind_teorico;
	private Button btn_veic;
		
	public void onClick$btn_regi(ForwardEvent e){
		materialGDAO = new MaterialGeralDAO();
		matgeral = new MaterialGeral();
		mat = new Material();
		materialDao= new MaterialDAO();
		
		mat.setNome(txt_designacao.getValue());
		mat.setGarantia(txt_garantia.getValue());
		
		mat.setData_aquisicao(dt_aquisicao.getValue());
		mat.setCreated_at(new Date());
		mat.setPreco(Double.parseDouble(txt_preco.getValue()));
		mat.setDescricao(txt_descricao.getValue());
		mat.setUpdated_at(new Date());
		mat.setExiste(true);
		materialDao.create(mat);
		
		matgeral.setCreated_at(new Date());
		matgeral.setUpdated_at(new Date());
		matgeral.setMaterial(mat);
		materialGDAO.create(matgeral);
		
		t=(Turma)Executions.getCurrent().getDesktop().getSession().getAttribute("TURMALINHA");
		
		matAlDao= new MaterialAlocacaoDAO();
		matAlo = new MaterialAlocacao();
		matAlo.setMaterial(mat);
		matAlo.setTurma(t);
		matAlo.setCreated_at(new Date());
		matAlo.setData_alocacao(new Date());
		matAlo.setData_saida(new Date());
		matAlDao.create(matAlo);
		
		Clients.showNotification("Material Registado com sucesso");
		
		Executions.sendRedirect("material_listar.zul");	
	}
	
	
	
	public void onClick$btn_actual(ForwardEvent e){
		materialGDAO = new MaterialGeralDAO();
		matgeral = new MaterialGeral();
		mat = new Material();
		materialDao= new MaterialDAO();
		
		mat.setId(Long.parseLong(lb_material_id.getValue()));
		mat.setNome(txt_designacao.getValue());
		mat.setGarantia(txt_garantia.getValue());
		
		mat.setData_aquisicao(dt_aquisicao.getValue());
		String criado=lb_created.getValue();
		//mat.setCreated_at(created_at);
		mat.setPreco(Double.parseDouble(txt_preco.getValue()));
		mat.setDescricao(txt_descricao.getValue());
		mat.setUpdated_at(new Date());
		mat.setExiste(true);
		materialDao.update(mat);
		
		matgeral.setId(Long.parseLong(lb_materialgeral_id.getValue()));
		matgeral.setCreated_at(new Date());
		matgeral.setUpdated_at(new Date());
		matgeral.setMaterial(mat);
		materialGDAO.update(matgeral);
		
		t=(Turma)Executions.getCurrent().getDesktop().getSession().getAttribute("TURMALINHA");
		
		matAlDao= new MaterialAlocacaoDAO();
		matAlo = new MaterialAlocacao();
		matAlo.setMaterial(mat);
		matAlo.setTurma(t);
		matAlo.setCreated_at(new Date());
		matAlo.setData_alocacao(new Date());
		matAlo.setData_saida(new Date());
		matAlDao.create(matAlo);
		
		Clients.showNotification("Material Actualizado com sucesso");
		
		Executions.sendRedirect("material_listar.zul");	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void onClick$btn_aloc_turma(Event e){
		 window = (Window) Executions.createComponents("turma_listar_alocar.zul", null,null);
		 window.doModal();
		 
		//Executions.createComponents("registo_material_teorico.zul", null,null);
	}
	public void onClick$linha(ForwardEvent e) {
		
		t = (Turma)((Listitem) e.getOrigin().getTarget()).getValue();
		turma_id= t.getId();
		Executions.getCurrent().getDesktop().getSession().setAttribute("TURMALINHA", t);
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
	
	public void onClick$actualizar(ForwardEvent e){
		
		Button b = (Button)e.getOrigin().getTarget();
		
		veiculo = (Veiculo)((Listitem)b.getParent().getParent()).getValue();
		
	    Map<String, Veiculo> h = new HashMap<>();
	    h.put("1", veiculo);
	
		
	    Executions.createComponents("material_veiculo_actualizar.zul", null, h);
	}
	
	public void onClick$actualizarpatico(ForwardEvent e){
		
		Button b = (Button)e.getOrigin().getTarget();
		
		matgeral = (MaterialGeral)((Listitem)b.getParent().getParent()).getValue();
		
	    Map<String, MaterialGeral> m = new HashMap<>();
	    m.put("1", matgeral);
	
		
	    Executions.createComponents("material_pratico_actualizar.zul", null, m);
	}
	
	
	

	public List <Turma> getTurmas(){
		return turmaDao.findAll();
	}
	
	public List <MaterialGeral> getMaterialGerais(){
		MaterialGeralDAO mtgeralDAO = new MaterialGeralDAO();
		List<MaterialGeral> mtger =mtgeralDAO.findAll();
		return mtger;
	}
	
	public List <MaterialAlocacao> getMateriaisGerais(){
		return new MaterialAlocacaoDAO().findAll();
	}
	
	public void onClick$fechar(Event e){
		
		wind_turma_aloc.setVisible(false);
	}
	
	
	
	
	
	
}
