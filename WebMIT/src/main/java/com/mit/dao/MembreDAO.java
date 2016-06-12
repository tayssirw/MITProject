package com.mit.dao;


import org.hibernate.criterion.Criterion;

import com.mit.entity.Membre;

public interface MembreDAO extends GenericDAO {
	@SuppressWarnings("rawtypes")
	public Object loginMembre(Class clazz, Criterion critere1, Criterion critere2);
	
	public Membre login(String email, String password );

}
