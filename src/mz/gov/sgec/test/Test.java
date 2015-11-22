package mz.gov.sgec.test;

import java.util.Date;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import mz.gov.sgec.dao.MaterialAlocacaoDAO;
import mz.gov.sgec.dao.MaterialDAO;
import mz.gov.sgec.dao.MaterialGeralDAO;
import mz.gov.sgec.dao.TurmaDAO;
import mz.gov.sgec.dao.UtilizadorDAO;

import mz.gov.sgec.dao.VeiculoDAO;
import mz.gov.sgec.model.Funcionario;
import mz.gov.sgec.model.Material;
import mz.gov.sgec.model.MaterialAlocacao;
import mz.gov.sgec.model.MaterialGeral;
import mz.gov.sgec.model.Turma;
import mz.gov.sgec.model.Utilizador;

import mz.gov.sgec.model.Veiculo;

public class Test {

	public static void main(String[] args) {
		//UtilizadorDAO ud = new UtilizadorDAO();
		//Utilizador u = new Utilizador();
		/*
		UtilizadorDAO ud =new UtilizadorDAO();
		Utilizador u = new Utilizador();
		Funcionario func = new Funcionario();
		func.setNome("Luisa");
		//u.setFuncionario("ya");
		u.setSenha("gh");
		u.setEmail("hjh");
		u.setTipo("yaa");
		ud.create(u);
		
		// TODO Auto-generated method stub
		MaterialDAO materialDAO = new MaterialDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		MaterialGeralDAO geralDAO = new MaterialGeralDAO();
		
		Material material = new Material();
		material.setCreated_at(new Date());
		material.setData_aquisicao(new Date());
		material.setDescricao("Veiculo novo");
		material.setExiste(true);
		material.setNome("BMW");
		material.setPreco(10000);
		material.setUpdated_at(new Date());
		materialDAO.create(material);
		
		Veiculo veiculo = new Veiculo();
		veiculo.setAno_fabrico(new Date());
		veiculo.setClasse("Pesado");
		veiculo.setCreated_at(new Date());
		veiculo.setLotacao("4");
		veiculo.setMarca("AM 318");
		veiculo.setMatricula("ADV 430 DE");
		veiculo.setPeso_bruto(12.2);
		veiculo.setTara("3 taras");
		veiculo.setTipo_combustivel("Diesel");
		veiculo.setUpdated_at(new Date());
		veiculo.setMaterial(material);
		veiculoDAO.create(veiculo);
		
		
		MaterialGeral materialGeral = new MaterialGeral();
		materialGeral.setCreated_at(new Date());
		materialGeral.setMaterial(material);
		materialGeral.setTipo_mat(1);
		materialGeral.setUpdated_at(new Date());
		geralDAO.createMaterial(materialGeral, 5);
		
		
		TurmaDAO turmaDAO = new TurmaDAO();
		List<Turma> turmas=turmaDAO.findAll();
		for (int i = 0; i < turmas.size(); i++) {
			System.out.println(turmas.get(i).toString()+"/n");
		}
		*/
		
		/*
		Turma turma = new Turma();
		turma.setCreated_at(new Date());
		turma.setHora_inicio("07:00");
		turma.setHora_fim("10:00");
		turma.setExiste(true);
		turma.setNome("Nome");
		turma.setSala("Sala");
		turma.setUpdated_at(new Date());
		
		
		//turmaDAO.create(turma);
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		List<Veiculo> veiculos = veiculoDAO.findAll();
		
		for (int i = 0; i < veiculos.size(); i++) {
			System.out.println(veiculos.get(i)+"\n");
		}
		*/
		
		/*MaterialAlocacaoDAO materialAlocacaoDAO = new MaterialAlocacaoDAO();
		List<MaterialAlocacao> veiculos = materialAlocacaoDAO.findAll();
		
		for (int i = 0; i < veiculos.size(); i++) {
			System.out.println(veiculos.get(i).getTurma()+"\n");
		}*/
		
		/*
		MaterialGeralDAO materialGeral= new MaterialGeralDAO();
		List<MaterialGeral> mtgeral =materialGeral.findAll();
		for(int i = 0; i<mtgeral.size(); i++){
			System.out.println(mtgeral.get(i).toString()+"\n");
		}
		*/
		/*
		MaterialAlocacaoDAO matAl = new MaterialAlocacaoDAO();
		List<MaterialAlocacao> mtAlo= matAl.findAll();
		for (int i = 0; i < mtAlo.size(); i++) {
			System.out.println(mtAlo.get(i).toString()+"\n");
		}*/
		//////////////////////////////////
		/*
		MaterialGeralDAO mtgeralDAO= new MaterialGeralDAO();
		MaterialGeral mtgeral= new MaterialGeral();
		MaterialDAO mtDAO= new MaterialDAO();
		Material mt= new Material();
		mt.setNome("kkkkk");
		mt.setDescricao("kkkkk");
		
		mtDAO.create(mt);
		
		mtgeral.setMaterial(mt);
		
		mtgeral.setTipo_mat(2);
		mtgeralDAO.create(mtgeral);
		
		Turma t= new Turma();
		TurmaDAO tDAO=new TurmaDAO();
		t=tDAO.findAll().get(1);
		
		MaterialAlocacao mtalo=new MaterialAlocacao();
		mtalo.setTurma(t);
		mtalo.setMaterial(mt);
		mtalo.setData_alocacao(new Date());
		MaterialAlocacaoDAO mtaloDAO= new MaterialAlocacaoDAO();
		mtaloDAO.create(mtalo);
		*/
		/////////////////update
		/*Turma t= new Turma();
		TurmaDAO tDAO=new TurmaDAO();
		t.setNome("noite");
		t.setId(3);
		tDAO.update(t);
		*/
		////////Separa string
		/*
		String line="1|value";
		String[] separated = line.split("\\|");
		System.out.println(separated[0].toString());
		////////////
		String line="1:value";
		String[] separated = line.split("\\:");
		System.out.println(separated[1].toString());
		*/
		
		
	}
}