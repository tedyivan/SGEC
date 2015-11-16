package mz.gov.sgec.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;

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
		private Datebox d_validade_bi;
		private Listbox lst_instruendo;

		private Button btn_reg;
		private Button btn_turma;
		private Button btn_pagamento;
		private Button btn_actualizar;
		//private Button btn_act;
		private TurmaDAO tdao = new TurmaDAO();
		private InstruendoDAO idao = new InstruendoDAO();
		Instruendo instruendo = new Instruendo();
		
		public void onClick$btn_rpagamento(Event e){
			Executions.sendRedirect("instruendo_pagamento.zul");
		}
		public void onClick$btn_rturma(Event e){
			Executions.sendRedirect("instruendo_alocar.zul");
		}
		
		public void onClick$btn_reg(Event e){
			instruendo.setId((long)(Math.random()*1000000)+1);
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
						
			idao.create(instruendo);			
			Clients.showNotification("Registo de Instruendo"); 
			clear();
		}

		public void onClick$btn_actualizar(){
			long id = 2;
			instruendo.setId(id);
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
			
			idao.update(instruendo);			
			Clients.showNotification("Actualiacao efectuada com Instruendo"); 
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
}