package mz.gov.sgec.controller;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import antlr.debug.Event;
import mz.gov.sgec.dao.UtilizadorDAO;
import mz.gov.sgec.model.Utilizador;

public class UtilizadorController extends GenericForwardComposer{
	
	private Textbox txt_nomeUtilizador;
	private Textbox txt_senha;
	private Button btn_entrar, btn_cancelar;
	private UtilizadorDAO dao = new UtilizadorDAO();
	
	
	public void clear() {
		txt_nomeUtilizador.setText(" ");
		txt_senha.setText(" "); 
	}

}