package mz.gov.sgec.controller;
import mz.gov.sgec.dao.UtilizadorDAO;
import mz.gov.sgec.model.Utilizador;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

public class AutenticacaoController extends GenericForwardComposer {
	private Textbox txt_utilizador;
	private Textbox txt_senha;
	private Button btn_entrar, btn_cancelar;
	private UtilizadorDAO dao = new UtilizadorDAO();
	//private A a_criar_conta;
	
	public void onClick$btn_entrar(){
		Utilizador util = dao.vericaUser(txt_utilizador.getText(),txt_senha.getText());
		
		if(util != null){
			Executions.sendRedirect("index.zul");			
		}	
		else
			Clients.showNotification("Dados invalidos");
	}
	public void onClick$a_criar_conta(Event e){
		Executions.sendRedirect("criar_conta.zul");
	}
}