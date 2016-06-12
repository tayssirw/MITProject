package com.mit.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.AdministrateurDAO;
import com.mit.entity.Administrateur;

@Transactional
@Repository("AdminDao")
public class AdministrateurDAOImpl extends GenericDAOImpl implements AdministrateurDAO {

	@SuppressWarnings("rawtypes")
	@Override
	public Object loginAdmin(Class clazz, Criterion critere1, Criterion critere2) {
		
		
		Criteria crit= sessionFactory.getCurrentSession().createCriteria(clazz)
				.add(critere1)
				.add(critere2);
		
	return crit.uniqueResult();
	}

	@Override
	public Administrateur login(String login, String password) {
		Administrateur a=new Administrateur();
		Query query=sessionFactory.getCurrentSession().createQuery("from administrteur a where a.login= :login and a.password= :password");
		query.setParameter(":username", login);
		query.setParameter(":password", password);
		a=(Administrateur)query.list().get(0);
		return a ;
	}

}
