package com.mit.daoImp;

import com.mit.dao.ContratMembreDAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



//@Repository("contratDao")
@Repository("contratMembreDao")
@Transactional
public class ContratMembreDAOImpl extends GenericDAOImpl implements ContratMembreDAO {

}
