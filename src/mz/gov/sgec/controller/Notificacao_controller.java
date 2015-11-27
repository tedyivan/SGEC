package mz.gov.sgec.controller;

import java.util.List;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Combobox;


import mz.gov.sgec.dao.AssuntoDAO;
import mz.gov.sgec.dao.InstruendoDAO;
import mz.gov.sgec.dao.NotificacaoDAO;
import mz.gov.sgec.model.Assunto;
import mz.gov.sgec.model.Instruendo;
import mz.gov.sgec.model.Notificacao;
import mz.gov.sgec.model.Turma;

public class Notificacao_controller extends GenericForwardComposer {
	
	private Textbox txt_mensagem;
	
	
	private Combobox cb_assunto,cb_destina;
	private Assunto assunto;
	private Notificacao notificacao;
	private NotificacaoDAO notificacaoDAO;
	private Instruendo instruendo;
	private InstruendoDAO instruendoDAO;
	private AssuntoDAO assuntoDAO;
	
	public void onClick$addAssunto(ForwardEvent e){
		
		Executions.createComponents("notificacao_assunto_reg.zul", null, null);
	}
	
	
	public void onClick$addReg(ForwardEvent e){
		notificacaoDAO= new NotificacaoDAO();
		notificacao= new Notificacao();
		
		EmailController email= new EmailController();
		//instruendo = new Instruendo();
		instruendoDAO= new InstruendoDAO();
		//assunto= new Assunto();
		/*List<Assunto> result=assuntoDAO.findAll();
		 for (int i = 0; i < result.size(); i++){
					if (assunto.getNome().equals(cb_assunto.getText()))
						assunto=result.get(i);;
						
		}*/
		
		 List<Instruendo> resulta=instruendoDAO.findAll();
		 
		 for (int i = 0; i < resulta.size(); i++){
			 
					if (resulta.get(i).getNome().equals(cb_destina.getText()))
						instruendo=resulta.get(i);
						
		}
				 
		
		notificacao.setInstruendo(instruendo);
		notificacao.setAssunto(assunto);
		
		notificacao.setMensagem(txt_mensagem.getValue());
		
		notificacaoDAO.create(notificacao);
		//email.enviarEmail(instruendo.getEmail(), titulo, mensagem);
		
		//Clients.showNotification("Notificacao "+notificacao.toString());
		
		//notificacao.setMensagem(txt_mensagem.getValue());
		//notificacao.setAssunto();
	}
	
	
	
	
	
	 public void onSearch(ForwardEvent v) {
		 /*assunto=(Assunto)((ComboBox)event.getOrigin().getTarget()).get;
		 Turma Turma = (Turma)((Listitem)b.getParent().getParent()).getValue();
		 Clients.showNotification("Aloo"+cb_assunto.getText());
		 /*List <Assunto> result = getAssuntos();
						
			for (int i = 0; i < result.size(); i++){
				assunto = result.get(i);
					if (assunto.getNome().equals(cbx_assunto.getText()){
					txt_mensagem
				}
			}*/
		 //assunto=(Assunto)((Combobox)v.getTarget().getAttribute().;
		 assuntoDAO =new AssuntoDAO();
		 Assunto prov;
		 List<Assunto> res=assuntoDAO.findAll();
		 for (int i = 0; i < res.size(); i++){
				prov = res.get(i);
					if (prov.getNome().equals(cb_assunto.getText())){
						assunto=res.get(i);;
						txt_mensagem.setText(assunto.getMesage());
					}
		 
		 }
		 		 
	    }
	
	
	
	public List<Assunto> getAssuntos(){
		return new AssuntoDAO().findAll();
	}

	public List<Instruendo> getInstruendos(){
		return new InstruendoDAO().findAll();
	}
}
