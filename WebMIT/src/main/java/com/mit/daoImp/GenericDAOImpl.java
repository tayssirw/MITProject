package com.mit.daoImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.mit.dao.GenericDAO;
@Repository("genericDao")
@Transactional
public class GenericDAOImpl implements GenericDAO {
	
//	@Autowired
	
//	HibernateTemplate template;
	
	@Autowired
	protected SessionFactory sessionFactory;

public void saveOrUpdate(Object entity) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().saveOrUpdate(entity);
	
}

public void delete(Object entity) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().delete(entity);
}

public List<?> findAll(Class<?> clazz) {
	// TODO Auto-generated method stub
	List<?> list = new ArrayList<Object>();
	Query query =  sessionFactory.getCurrentSession().createQuery("from "+clazz.getName());
	list = query.list();
	return list;
}

public List<?> findByCriteria(Class<?> clazz, Criterion critere) {
	// TODO Auto-generated method stub
	List<?> objects = null;
	
	Criteria crit= sessionFactory.getCurrentSession().createCriteria(clazz).add(critere);
	objects=crit.list();
return objects;
}

public Object findBy(Class<?> clazz,Serializable id)
{
		return sessionFactory.getCurrentSession().get(clazz, id);
}

public Object findById(Class<?> clazz, Serializable id) {
	// TODO Auto-generated method stub
	Object e = sessionFactory.getCurrentSession().load(clazz, id);
	return e;
}
	

}
