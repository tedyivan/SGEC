package mz.gov.sgec.controller;



import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

import mz.gov.sgec.dao.MaterialDAO;
import mz.gov.sgec.dao.VeiculoDAO;
import mz.gov.sgec.model.Material;
import mz.gov.sgec.model.Veiculo;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;

public class MaterialController extends GenericForwardComposer{
	private Button btn_open;
	MaterialDAO dao = new MaterialDAO(); 
	VeiculoDAO veiculoDAO = new VeiculoDAO();
	
	/*public void open(){
		
		Executions.createComponents("registo_material_teorico.zul", null,null);
	}*/
	
	public void onClick$btn_open(Event e){
		final Window window = (Window) Executions.createComponents("registo_material_teorico.zul", null,null);
		window.doModal();
		//Executions.createComponents("registo_material_teorico.zul", null,null);
	}
	
	public void onClick$btn_opreg(Event e){
		final Window window = (Window) Executions.createComponents("material_registo.zul", null,null);
		window.doModal();
		//Executions.createComponents("registo_material_teorico.zul", null,null);
	}
	
	
	public List<Material> getMateriais(){
		return dao.findAll();
	}
	
		
	
}
