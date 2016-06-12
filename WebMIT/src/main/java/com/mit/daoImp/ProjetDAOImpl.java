package com.mit.daoImp;

import com.mit.dao.ProjetDAO;

import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//@Repository("projetDao")
@Repository("projetDao")
@Transactional
public class ProjetDAOImpl extends GenericDAOImpl implements ProjetDAO{

	}
