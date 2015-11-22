package mz.gov.sgec.controller;

import java.util.List;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;

import mz.gov.sgec.dao.AssuntoDAO;
import mz.gov.sgec.model.Assunto;

public class Notificacao_controller extends GenericForwardComposer {
	
	private Textbox txt_mensagem,cbx_assunto;
	
	private Assunto assunto;
	
	
	
	public void onClick$addAssunto(ForwardEvent e){
		
		Executions.createComponents("notificacao_assunto_reg.zul", null, null);
	}
	
	 public void onSelect(ForwardEvent e) {
		 Clients.showNotification(cbx_assunto.getText());
		 /*List <Assunto> result = getAssuntos();
						
			for (int i = 0; i < result.size(); i++){
				assunto = result.get(i);
					if (assunto.getNome().equals(cbx_assunto.getText()){
					txt_mensagem
				}
			}*/
			
	    }
	
	
	
	public List<Assunto> getAssuntos(){
		return new AssuntoDAO().findAll();
	}

}
