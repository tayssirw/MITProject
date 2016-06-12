package com.mit.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDAO {

	
	public void saveOrUpdate(Object entity);
	public void delete(Object entity);
	public List<?>findAll(Class<?> clazz);
	public List<?> findByCriteria(Class<?> clazz, Criterion critere);
	public Object findById(Class<?> clazz, Serializable id);
	public Object findBy(Class<?> clazz,Serializable id);
}
