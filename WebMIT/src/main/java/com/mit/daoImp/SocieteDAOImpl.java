package com.mit.daoImp;

import com.mit.dao.SocieteDAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("societeDao")
@Transactional
public class SocieteDAOImpl extends GenericDAOImpl implements SocieteDAO{

	}
