package mz.gov.sgec.controller;

import java.util.Date;

import org.eclipse.swt.widgets.Spinner;
import org.python.util.Generic;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timer;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;


import mz.gov.sgec.dao.TurmaDAO;
import mz.gov.sgec.model.Turma;


public class Turma_controller extends GenericForwardComposer{
	private Textbox txt_designacao, txt_sala,txt_descricao;
	private Intbox spn_lotacao, spn_periodo, spn_periodo1,spn_periodo2,spn_periodo3;
	private Button btn_ok, btn_cancelar;
	private String horaInicio,horaFim;
	
	
	
	
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
		
	}
	
	
	

}
