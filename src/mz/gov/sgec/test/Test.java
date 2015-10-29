package mz.gov.sgec.test;

import java.util.Date;

import mz.gov.sgec.dao.MaterialDAO;
import mz.gov.sgec.dao.MaterialGeralDAO;
import mz.gov.sgec.dao.TurmaDAO;
import mz.gov.sgec.dao.VeiculoDAO;
import mz.gov.sgec.model.Material;
import mz.gov.sgec.model.MaterialGeral;
import mz.gov.sgec.model.Turma;
import mz.gov.sgec.model.Veiculo;

public class Test {

	public static void main(String[] args) {
		/*
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
		*/
		
		TurmaDAO turmaDAO = new TurmaDAO();
		Turma turma = new Turma();
		turma.setCreated_at(new Date());
		turma.setData_fim(new Date());
		turma.setExiste(true);
		turma.setNome("Nome");
		turma.setSala("Sala");
		turma.setUpdated_at(new Date());
		
		turmaDAO.create(turma);
		
	}
}