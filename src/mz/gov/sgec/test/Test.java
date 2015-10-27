package mz.gov.sgec.test;

import java.util.Date;

import mz.gov.sgec.dao.MaterialDAO;
import mz.gov.sgec.dao.MaterialGeralDAO;
import mz.gov.sgec.dao.VeiculoDAO;
import mz.gov.sgec.model.Material;
import mz.gov.sgec.model.MaterialGeral;
import mz.gov.sgec.model.Veiculo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaterialDAO materialDAO = new MaterialDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		MaterialGeralDAO geralDAO = new MaterialGeralDAO();
		
		Material material = new Material();
		material.setCreated_at(new Date());
		material.setData_aquisicao(new Date());
		material.setDescricao("Descricao");
		material.setExiste(true);
		material.setNome("Nome");
		material.setPreco(10000);
		material.setUpdated_at(new Date());
		materialDAO.create(material);
		
		Veiculo veiculo = new Veiculo();
		veiculo.setAno_fafabrico(new Date());
		veiculo.setClasse("Classe");
		veiculo.setCreated_at(new Date());
		veiculo.setLotacao("1");
		veiculo.setMarca("marca");
		veiculo.setMatricula("matricula");
		veiculo.setPeso_bruto(12.2);
		veiculo.setTara("tara");
		veiculo.setTipo_combustivel("tipo_combustivel");
		veiculo.setUpdated_at(new Date());
		veiculo.setMaterial(material);
		veiculoDAO.create(veiculo);
		
		MaterialGeral materialGeral = new MaterialGeral();
		materialGeral.setCreated_at(new Date());
		materialGeral.setMaterial(material);
		materialGeral.setTipo_mat(1);
		materialGeral.setUpdated_at(new Date());
		geralDAO.createMaterial(materialGeral, 5);
		
	}

}
