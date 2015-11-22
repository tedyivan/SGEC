package mz.gov.sgec.dao;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mz.gov.sgec.model.Utilizador;

public class UtilizadorDAO extends GenericDAO<Utilizador>{
	
	public UtilizadorDAO() {
		super(Utilizador.class);
		
	}

	public Utilizador vericaUser(String utilizador, String senha){
			Session sess = getSession();
			Transaction tx = sess.beginTransaction();
			Criteria criteria = sess.createCriteria(getClazz());
			criteria.add(Restrictions.eq("utilizador",utilizador));
			criteria.add(Restrictions.eq("senha",senha));
			Utilizador util = (Utilizador)criteria.uniqueResult();
			tx.commit();
			return util;				
	}
}