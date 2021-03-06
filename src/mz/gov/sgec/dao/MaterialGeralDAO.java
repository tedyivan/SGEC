package mz.gov.sgec.dao;

import mz.gov.sgec.model.MaterialGeral;

public class MaterialGeralDAO extends GenericDAO<MaterialGeral>{

	public MaterialGeralDAO() {
		super(MaterialGeral.class);
	}
	
	public boolean createMaterial(MaterialGeral materialGeral, int quantidade) {
		
		for (int i = 0; i < quantidade; i++) {
			create(materialGeral);
		}
		return true;
	}

}
