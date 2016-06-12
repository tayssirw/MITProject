package com.mit.daoImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.DiplomeDAO;

@Repository("diplomeDao")
@Transactional
public class DiplomeDAOImpl extends GenericDAOImpl implements DiplomeDAO{

}
