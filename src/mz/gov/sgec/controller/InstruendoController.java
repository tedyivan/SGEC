package mz.gov.sgec.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.zkoss.bind.annotation.DependsOn;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.event.OpenEvent;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import mz.gov.sgec.dao.InstruendoDAO;
import mz.gov.sgec.dao.TurmaDAO;
import mz.gov.sgec.model.Instruendo;
import mz.gov.sgec.model.Turma;

public class InstruendoController extends GenericForwardComposer {
		
		//private Div registo;
		private Textbox txt_apelido;		
		private Textbox txt_apelido_pai;
		private Textbox txt_apelido_mae;		
		private Textbox txt_codigo_barra;
		private Textbox txt_celular;
		private Textbox cb_civil;
		private Radiogroup rd_genero;
		private Spinner sp_inteiro;
		private Spinner sp_decimal;
		private Datebox d_nascimento;
		private Textbox txt_naturalidade;
		private Textbox txt_nome;
		private Textbox txt_nome_pai;
		private Textbox txt_nome_mae;
		private Textbox txt_numero_bi;
		private Textbox txt_residencia;
		private Combobox cb_tipo_carta;
		private Combobox cb_turma;
		private Datebox d_validade_bi;
		private Listbox lst_instruendo, listbox_teste;
		private Textbox txt_nome_t;
		private Combobox turma_teste;
		private Listbox lst_alocar_instruendo;
		private Combobox alocar_turma;

		private long turma_id;
		private long instruend_id;	
		private TurmaDAO tdao = new TurmaDAO();
		private Turma turma = new Turma();
		private InstruendoDAO idao = new InstruendoDAO();
		private Instruendo instruendo = new Instruendo();
		private String instruendo_bi;
		
		public void onClick$voltar_l(Event e){
			Executions.sendRedirect("instruendo_listar.zul");
		}
		public void onClick$actualizar(ForwardEvent e){
			Button b = (Button)e.getOrigin().getTarget();
			Listitem li = ((Listitem)b.getParent().getParent());
			li.setSelected(true);
		    instruendo = (Instruendo) li.getValue();
		    Map <String,Instruendo> h = new HashMap<>();
		    h.put("1", instruendo);
		    Executions.createComponents("instruendo_actualizar.zul", null, h);
		}
		//lista inst
		public void onClick$alocar(ForwardEvent e){
			Button b = (Button)e.getOrigin().getTarget();
			Listitem li = ((Listitem)b.getParent().getParent());
			li.setSelected(true);
		    instruendo = (Instruendo) li.getValue();
		    Map <String,Instruendo> h = new HashMap<>();
		    h.put("1", instruendo);
			Executions.createComponents("instruendo_alocar_turma.zul",null,h);
		}
		//alocar na lista 
		public void onClick$detac_alocar(ForwardEvent e){
			List <Instruendo> result = getInstruendos();
			List <Turma> result_t = getTurmas();
			Turma t;
			Instruendo inst;
			
			//long inst_id = 0;
			Listitem lstit = lst_alocar_instruendo.getSelectedItem();
			instruendo.setNome(((Listcell)lstit.getChildren().get(1)).getLabel());
			turma.setNome(alocar_turma.getText());			
			
			for (int i = 0; i < result_t.size(); i++){
				t = result_t.get(i);
				if (turma.getNome().equals(t.getNome())){
					turma_id = t.getId();
				}
			}
			
			for (int i = 0; i < result.size(); i++){
				inst = result.get(i);
				if (inst.getNome().equals(instruendo.getNome())){
					//problemas actualiazar Altura
					//instruendo.setAltura(result.get((int)instruend_id).getAltura());
					instruendo.setId(inst.getId());
					instruendo.setApelido(inst.getApelido());
					instruendo.setApelido_pai(inst.getApelido_pai());
					instruendo.setApelido_mae(inst.getApelido_mae());
					instruendo.setBi(inst.getBi());
					instruendo.setCodigo_barra(inst.getCodigo_barra());
					instruendo.setData_nascimento(inst.getData_nascimento());			
					instruendo.setEstado_civil(inst.getEstado_civil());
					instruendo.setGenero(inst.getGenero());
					instruendo.setNaturalidade(inst.getNaturalidade());
					instruendo.setNome(inst.getNome());
					instruendo.setNome_mae(inst.getNome_mae());
					instruendo.setNome_pai(inst.getNome_pai());
					instruendo.setResidencia(inst.getResidencia());
					instruendo.setTelefone(inst.getTelefone());
					instruendo.setTipo_carta(inst.getTipo_carta());
					instruendo.setValidade_bi(inst.getValidade_bi());
				}
			}
			
			turma.setId(turma_id);
			instruendo.setInst_turma(turma);
			idao.update(instruendo);
			
			Clients.showNotification("Alocado a nova turma Instruendo " + instruendo.getNome() + " a " + turma_id);
		}
		//lista inst
		public void onClick$pagar(){
			Clients.showNotification("pagar de Instruendo"); 
		}
		
		public void onClick$btn_pagamento(Event e){
			Window window = (Window) Executions.createComponents("instruendo_pagamento.zul",null,null);
			window.doModal();
		}
		//tedy ....
		public void onClick$linha(ForwardEvent e){
			turma = (Turma)((Listitem) e.getOrigin().getTarget()).getValue();
			turma_id = turma.getId();
			Executions.getCurrent().getDesktop().getSession().setAttribute("turma_id", turma_id);
		}
		
		public void onClick$btn_turma(ForwardEvent e){
			Window window = (Window) Executions.createComponents("instruendo_alocar.zul",null,null);
			window.doModal();
		}
		
		public void onClick$btn_reg(Event e){
		
			turma_id = (long) Executions.getCurrent().getDesktop().getSession().getAttribute("turma_id");
			turma.setId(turma_id);
			//instruendo.setId((long)(Math.random()*1000000)+1);
			instruendo.setAltura(Double.parseDouble(sp_inteiro.getValue()+"."+sp_decimal.getValue()));
			instruendo.setApelido(txt_apelido.getText());
			instruendo.setApelido_pai(txt_apelido_pai.getText());
			instruendo.setApelido_mae(txt_apelido_mae.getText());
			instruendo.setBi(txt_numero_bi.getText());
			instruendo.setCodigo_barra(txt_codigo_barra.getText());
			instruendo.setData_nascimento(d_nascimento.getValue());			
			instruendo.setEstado_civil(cb_civil.getText());
			instruendo.setGenero(rd_genero.getSelectedItem().getValue().toString());
			instruendo.setNaturalidade(txt_naturalidade.getText());
			instruendo.setNome(txt_nome.getText());
			instruendo.setNome_mae(txt_nome_mae.getText());
			instruendo.setNome_pai(txt_nome_pai.getText());
			instruendo.setResidencia(txt_residencia.getText());
			instruendo.setTelefone(txt_celular.getText());
			instruendo.setTipo_carta(cb_tipo_carta.getValue());
			instruendo.setValidade_bi(d_validade_bi.getValue());			
			instruendo.setInst_turma(turma);
			
			idao.create(instruendo);
			Clients.showNotification("Registo de Instruendo"+ turma_id); 
			clear();
		}

		public void onClick$btn_actualizar(Event e){
			//moiane
			List <Instruendo> result = getInstruendos();
			Instruendo instruend;
			instruendo.setBi(txt_numero_bi.getText());
			instruendo.setApelido(txt_apelido.getText());
			instruendo.setNome(txt_nome.getText());
			
			//Teste actualizacao
		    for (int i = 0; i < result.size(); i++){
				instruend = (Instruendo) result.get(i);
				if(instruend.getBi().equals(instruendo.getBi()) || instruend.getNome().equals(instruendo.getNome()) || instruend.getApelido().equals(instruendo.getApelido())){
			    	instruend_id = instruend.getId();
			    }
		    }
			instruendo.setId(instruend_id);
			instruendo.setAltura(Double.parseDouble(sp_inteiro.getValue()+"."+sp_decimal.getValue()));
			
			instruendo.setApelido_pai(txt_apelido_pai.getText());
			instruendo.setApelido_mae(txt_apelido_mae.getText());
			//instruendo.setBi(txt_numero_bi.getText());
			instruendo.setCodigo_barra(txt_codigo_barra.getText());
			instruendo.setData_nascimento(d_nascimento.getValue());			
			instruendo.setEstado_civil(cb_civil.getText());
			instruendo.setGenero(rd_genero.getSelectedItem().getValue().toString());
			instruendo.setNaturalidade(txt_naturalidade.getText());
			instruendo.setNome_mae(txt_nome_mae.getText());
			instruendo.setNome_pai(txt_nome_pai.getText());
			instruendo.setResidencia(txt_residencia.getText());
			instruendo.setTelefone(txt_celular.getText());
			instruendo.setTipo_carta(cb_tipo_carta.getValue());
			instruendo.setValidade_bi(d_validade_bi.getValue());
			
			Executions.sendRedirect("");
			idao.update(instruendo);			
			Clients.showNotification("Actualiacao efectuada com Instruendo  "+instruend_id); 
			clear();
		}
		
		public void clear() {
			sp_inteiro.setValue(0);
			sp_decimal.setValue(0);
			txt_apelido.setText(" ");
			txt_apelido_pai.setText(" ");
			txt_apelido_mae.setText(" ");
			txt_numero_bi.setText(" ");
			txt_codigo_barra.setText(" ");
			txt_nome.setText(" ");
			txt_nome_mae.setText(" ");
			txt_nome_pai.setText(" ");
			txt_residencia.setText(" ");
			txt_celular.setText(" ");
			txt_naturalidade.setText(" ");
			rd_genero.setSelectedItem(null);
			cb_civil.setText(" ");
			cb_tipo_carta.setText(" ");
			d_validade_bi.setText(null);			
			d_nascimento.setText(null);
		}
		
		public List <Turma> getTurmas(){
			return new TurmaDAO().findAll();
		}
		
		public List <Instruendo> getInstruendos(){
			return idao.findAll();
		}
		
		public Instruendo getInstruendo(){	
			Instruendo inst = new Instruendo();
			long id = 2;
			inst.setId(id);
			return idao.findById(inst.getId());
		}
		
		public void onSearch(ForwardEvent event) {
			List <Instruendo> result = getInstruendos();
			List <Turma> result_t = getTurmas();
			turma.setNome(turma_teste.getText());
			for (int i = 0; i < result.size(); i++){
				instruendo = result.get(i);
					if (turma.getNome().equals(instruendo.getInst_turma().getNome())){
					addTesteInstruendo(instruendo);
				}
			}
			Clients.showNotification("Teste k" +turma.getNome());
	    }
		
		private void addTesteInstruendo(Instruendo inst){
			Listitem lstit = new Listitem();
			
			Listcell lstcl = new Listcell(String.valueOf(inst.getId()));
			Textbox text = new Textbox();
			
			lstcl = new Listcell(inst.getCodigo_barra());
			lstit.appendChild(lstcl);
			
			lstcl = new Listcell(inst.getNome());
			lstit.appendChild(lstcl);

			lstcl = new Listcell(inst.getApelido());
			lstit.appendChild(lstcl);
			
			lstcl = new Listcell();
			text = new Textbox(inst.getApelido());
			text.setParent(lstcl);
			lstit.appendChild(lstcl);
			
			lstcl = new Listcell();
			text = new Textbox(inst.getApelido());
			text.setParent(lstcl);
			lstit.appendChild(lstcl);
			
			lstcl = new Listcell();
			text = new Textbox(inst.getApelido());
			text.setParent(lstcl);
			lstit.appendChild(lstcl);
			
			lstcl = new Listcell();
			text = new Textbox(inst.getApelido());
			text.setParent(lstcl);
			lstit.appendChild(lstcl);
			
			lstcl = new Listcell();
			text = new Textbox(inst.getApelido());
			text.setParent(lstcl);
			lstit.appendChild(lstcl);
			
			lstcl = new Listcell();
			text = new Textbox(inst.getApelido());
			text.setParent(lstcl);
			lstit.appendChild(lstcl);
			
			lstcl = new Listcell();
			text = new Textbox(inst.getApelido());
			text.setParent(lstcl);
			lstit.appendChild(lstcl);
			
			lstcl = new Listcell();
			text = new Textbox(inst.getApelido());
			text.setParent(lstcl);
			lstit.appendChild(lstcl);
			
			lstit.setValue(inst);
			listbox_teste.appendChild(lstit);
		}
}