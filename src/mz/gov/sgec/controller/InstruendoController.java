package mz.gov.sgec.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/*
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;
*/
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import mz.gov.sgec.dao.InstruendoDAO;
import mz.gov.sgec.dao.TurmaDAO;
import mz.gov.sgec.model.Instruendo;
import mz.gov.sgec.model.Turma;

public class InstruendoController extends GenericForwardComposer {
		
		//private Div registo;
		//private Div listar;
		private Textbox txt_rapelido;		
		private Textbox txt_rapelido_pai;
		private Textbox txt_rapelido_mae;		
		private Textbox txt_rcodigo_barra;
		private Textbox txt_rcelular;
		private Textbox cb_rcivil;
		private Radiogroup txt_rgenero;
		private Intbox itx_rinteiro;
		private Intbox itx_rdecimal;
		private Datebox d_rnascimento;
		private Textbox txt_rnaturalidade;
		private Textbox txt_rnome;
		private Textbox txt_rnome_pai;
		private Textbox txt_rnome_mae;
		private Textbox txt_rnumero_bi;
		private Textbox txt_rresidencia;
		private Combobox cb_rtipo_carta;	
		private Datebox d_rvalidade_bi;
		private Listbox lst_instruendo;
		
		private Button btn_rreg;
		private Button btn_rturma;
		private Button btn_rpagamento;
		private TurmaDAO tdao = new TurmaDAO();
		private InstruendoDAO idao = new InstruendoDAO();
		
		public void onClick$btn_rpagamento(Event e){
			Executions.sendRedirect("instruendo_pagamento.zul");
		}
		public void onClick$btn_rturma(Event e){
			Executions.sendRedirect("instruendo_alocar.zul");
		}
		
		public void onClick$btn_rreg(Event e){
			Instruendo instruendo = new Instruendo();
			
			instruendo.setId((long)(Math.random()*1000000)+1);
			//instruendo.setAltura(itx_rinteiro.getValue()+""+itx_rdecimal.getValue());
			instruendo.setApelido(txt_rapelido.getText());
			instruendo.setApelido_pai(txt_rapelido_pai.getText());
			instruendo.setApelido_mae(txt_rapelido_mae.getText());
			instruendo.setBi(txt_rnumero_bi.getText());
			instruendo.setCodigo_barra(txt_rcodigo_barra.getText());
			instruendo.setData_nascimento(d_rnascimento.getValue());			
			instruendo.setEstado_civil(cb_rcivil.getText());
			//instruendo.setGenero(((Radio) txt_rgenero) getValue());
			instruendo.setNaturalidade(txt_rnaturalidade.getText());
			instruendo.setNome(txt_rnome.getText());
			instruendo.setNome_mae(txt_rnome_mae.getText());
			instruendo.setNome_pai(txt_rnome_pai.getText());
			instruendo.setResidencia(txt_rresidencia.getText());
			instruendo.setTelefone(txt_rcelular.getText());
			instruendo.setTipo_carta(cb_rtipo_carta.getValue());
			instruendo.setValidade_bi(d_rvalidade_bi.getValue());
						
			idao.create(instruendo);			
			Clients.showNotification("Registo de Instruendo"); 
			clear();
		}
		
		public void clear() {
			//instruendo.setAl
			txt_rapelido.setText(" ");
			txt_rapelido_pai.setText(" ");
			txt_rapelido_mae.setText(" ");
			txt_rnumero_bi.setText(" ");
			txt_rcodigo_barra.setText(" ");
			txt_rnome.setText(" ");
			txt_rnome_mae.setText(" ");
			txt_rnome_pai.setText(" ");
			txt_rresidencia.setText(" ");
			txt_rcelular.setText(" ");
			txt_rnaturalidade.setText(" ");
			cb_rcivil.setText(" ");
			cb_rtipo_carta.setText(" ");
			d_rvalidade_bi.setText(null);			
			d_rnascimento.setText(null);

			//instruendo.setG
		}
		
		public List <Turma> getTurmas(){
			return new TurmaDAO().findAll();
		}
		
		public List <Instruendo> getInstruendos(){
			return idao.findAll();
		}
		
		public Instruendo getInstruendo(){	
			Instruendo inst = new Instruendo();
			long id = 1;
			inst.setId(id);
			return idao.findById(inst.getId());
		}
		
	/*	private static final long serialVersionUID = 1L;
	     
		    @Wire
		    Window modalDialog;
		     
		    @Listen("onClick = #closeBtn")
		public void showModall(Event e) {
		        modalDialog.detach();
		}*/
		
	/*	@Listen("onClick = #orderBtn")
		public void showModal(Event e) {
		        //create a window programmatically and use it as a modal dialog.
		        Window window = (Window)Executions.createComponents("instruendo_pagamento.zul", null, null);
		        window.doModal();
		}*/
}