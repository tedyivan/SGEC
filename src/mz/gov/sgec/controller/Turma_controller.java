package mz.gov.sgec.controller;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.List;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import java.util.Date;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;


import mz.gov.sgec.dao.TurmaDAO;
import mz.gov.sgec.model.Turma;


public class Turma_controller extends GenericForwardComposer{
	private Textbox txt_designacao, txt_sala,txt_descricao;
	private Intbox spn_lotacao, spn_periodo, spn_periodo1,spn_periodo2,spn_periodo3;
	//private Button btn_ok, btn_cancelar, btn_edit;
	private String horaInicio,horaFim;
	//private Listbox lst_turmas;
	private Turma t;
	private TurmaDAO dao= new TurmaDAO(); 
	
	

	
	public void onClick$btn_reg(Event e){
		Turma turma= new Turma();
		TurmaDAO turmaDao= new TurmaDAO();
		horaInicio = spn_periodo.getValue()+":"+spn_periodo1.getValue();
		horaFim = spn_periodo2.getValue()+":"+spn_periodo3.getValue();
		turma.setExiste(true);
		
		turma.setSala(txt_sala.getValue());
		turma.setNome(txt_designacao.getValue());
		
		//Clients.showNotification(spn_periodo.);
		
		
		turma.setLotacao(Integer.toString(spn_lotacao.getValue()));
		turma.setHora_inicio(horaInicio);
		turma.setHora_fim(horaFim);
		turma.setDescricao(txt_descricao.getValue());
		turma.setCreated_at(new Date());
		turma.setUpdated_at(new Date());
		turmaDao.create(turma);
		
		Clients.showNotification("Turma "+turma.getNome()+" Registada com Sucesso!");
		
	}
	
	public void onClick$line(ForwardEvent e){
			Clients.showNotification("Yaaaaaaa");
			t=(Turma)((Listitem) e.getOrigin().getTarget()).getValue();
			Clients.showNotification(t.toString());
	}	
	
	
	public void onClick$btn_teste(ForwardEvent e){
		Clients.showNotification("Yaaaaaaa");
	}
	
	
	public List<Turma> getTurmas(){
		return dao.findAll();
	}
	

}
