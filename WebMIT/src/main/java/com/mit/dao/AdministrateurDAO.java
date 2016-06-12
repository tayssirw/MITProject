package com.mit.dao;


import org.hibernate.criterion.Criterion;

import com.mit.entity.Administrateur;

public interface AdministrateurDAO extends GenericDAO{
	@SuppressWarnings("rawtypes")
	public Object loginAdmin(Class clazz, Criterion critere1, Criterion critere2);
	public Administrateur login(String email, String password );


}
