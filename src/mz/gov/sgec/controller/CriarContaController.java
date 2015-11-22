package mz.gov.sgec.controller;

import java.util.List;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;

import mz.gov.sgec.dao.FuncionarioDAO;
import mz.gov.sgec.dao.UtilizadorDAO;
import mz.gov.sgec.model.Funcionario;
import mz.gov.sgec.model.Utilizador;

public class CriarContaController  extends GenericForwardComposer{
	    
	private Textbox txt_utilizador, txt_senha,txt_email;
	private Combobox cbx_tipo, cbx_fun;
	private Button btn_criar, btn_voltar;
		//private Textbox txt_repetirSenha;																																																					
		//private Radio rtn_mostrarSenha;
		
		private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		private UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
		
		public CriarContaController() {	}
		
		public List<Funcionario> getFuncionarios(){
			return funcionarioDAO.findAll();
		}
		
		public void onClick$btn_criar(Event e){
			Utilizador utilizador = new Utilizador();
			utilizador.setUtilizador(txt_utilizador.getText());
			utilizador.setEmail(txt_email.getText());
			utilizador.setTipo(cbx_tipo.getText());
			utilizador.setSenha(txt_senha.getText());
			
			utilizadorDAO.create(utilizador);
			clear();
			Clients.showNotification("Conta criada com sucesso");
			Executions.sendRedirect("autenticacao.zul");
		}
		public void clear(){
			cbx_fun.setValue(null);
			txt_utilizador.setText(" ");
			txt_email.setText(" ");
			cbx_tipo.setValue(" ");
			txt_senha.setText(" ");
		}
			
		//public void onClick$btn_voltar(Event e){
			//	Executions.sendRedirect("Autenticacao.zul");
			
		//}
		//public void onClick$rtn_mostrarSenha(Event e){
			
		//}
}