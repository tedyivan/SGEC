package mz.gov.sgec.controller;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Button;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Spinner;

public class EstatisticaController {
	private Listheader lst_fun_estatistica,lst_instru_estatistica, lst_quant_estatistica;
	private Button btn_relatorio;
	private Button btn_voltar;
	private Listbox lst_mat_estatistica;
	private Spinner spn_anoQuant;
	
	
	
	public void onClick$btn_voltar(){
		Executions.sendRedirect("estatistica_funcionario.zul");
	}
	
}
