package mz.gov.sgec.controller;
import mz.gov.sgec.dao.FuncionarioDAO;
import mz.gov.sgec.model.Funcionario;
//import mz.gov.sgec.model.Instruendo;

import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.Clients;

//import java.util.Date;
//import java.util.List;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;

public class FuncionarioController extends GenericForwardComposer{
	private FuncionarioDAO fdao = new FuncionarioDAO();
	private Funcionario funcionario = new Funcionario();
	
	private Textbox txt_nome;
	private Textbox txt_numBi;
	private Textbox txt_contacto;
	private Datebox d_nascimento;
	private Combobox cbx_categoria;
	private Textbox txt_apelido;
	private Textbox txt_nuit;
	private Textbox txt_email;
	
	private Button btn_reg;
	private Button txt_doc;
	
	public void onClick$btn_reg(Event e){
		funcionario.setId((long)(Math.random()*1000000)+1);
		funcionario.setNome(txt_nome.getText());
		funcionario.setApelido(txt_apelido.getText());
		funcionario.setNr_bi(txt_numBi.getText());
		funcionario.setData_nascimento(d_nascimento.getValue());
		funcionario.setCategoria(cbx_categoria.getText());
		funcionario.setEmail(txt_email.getText());
		funcionario.setNuit(txt_nuit.getText());
		funcionario.setContacto(txt_contacto.getText());
		
		fdao.create(funcionario);			
		Clients.showNotification("Registo de Funcionario efectuado com sucesso"); 
		clear();
	}
	
	public void clear() {
		txt_nome.setText(" ");
		txt_numBi.setText(" ");
		txt_contacto.setText(" ");
		txt_nuit.setText(" ");
		d_nascimento.setText(null);
		cbx_categoria.setText(" ");
		txt_email.setText(" ");
		txt_nuit.setText(" ");
		txt_apelido.setText(" ");
	}
	public List <Funcionario> getFuncionarios(){
		return fdao.findAll();
	}	
	public Funcionario getFuncionario(){	
		Funcionario func = new Funcionario();
		long id = 2;
		func.setId(id);
		return fdao.findById(func.getId());
	}
}