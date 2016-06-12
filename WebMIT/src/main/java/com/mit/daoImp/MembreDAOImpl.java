package com.mit.daoImp;

import java.util.List;

import com.mit.dao.MembreDAO;
import com.mit.entity.Membre;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("membreDao")
//@Service("membreDao")

@Transactional
public class MembreDAOImpl extends GenericDAOImpl implements MembreDAO{

	@SuppressWarnings("rawtypes")
	@Override
	public Object loginMembre(Class clazz, Criterion critere1, Criterion critere2) {
	//	List objects = null;
		
		Criteria crit= sessionFactory.getCurrentSession().createCriteria(clazz)
				.add(critere1)
				.add(critere2);
		return crit.uniqueResult();
//	return objects;
	}

	@Override
	public Membre login(String email, String password) {
		
		Query query=sessionFactory.getCurrentSession().createQuery("from membre  where email= ? and password= ?");
		query.setString(1, email);
		query.setString(2, password);
	//	m=(Membre)query.list().get(0);
		return (Membre) query.uniqueResult();
		//set String , return,(Membre)query.uniqueResult();
	}
	

	} 