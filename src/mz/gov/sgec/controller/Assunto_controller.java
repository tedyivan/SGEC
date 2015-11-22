package mz.gov.sgec.controller;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;

import mz.gov.sgec.dao.AssuntoDAO;
import mz.gov.sgec.model.Assunto;

public class Assunto_controller extends GenericForwardComposer {

	private Textbox txt_assunto, txt_mensagem;
	
	private Assunto assunto;
	private AssuntoDAO assuntoDAO;
	
	public void onClick$btn_reg(ForwardEvent e){
		assunto = new Assunto();
		assuntoDAO= new AssuntoDAO();
		assunto.setMesage(txt_mensagem.getValue());
		assunto.setNome(txt_assunto.getValue());
		assuntoDAO.create(assunto);
		Clients.showNotification("Assunto Registado com Sucesso");
		Executions.sendRedirect("notificacao_corpo.zul");
	}
  
	
	
	
}
