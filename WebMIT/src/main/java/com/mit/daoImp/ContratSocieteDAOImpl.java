package com.mit.daoImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.ContratSocieteDAO;

@Repository("contratSocieteDao")
@Transactional
public class ContratSocieteDAOImpl extends GenericDAOImpl implements ContratSocieteDAO {

}
