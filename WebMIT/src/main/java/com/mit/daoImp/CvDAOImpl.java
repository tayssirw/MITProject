package com.mit.daoImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.CvDAO;

@Repository("cvDao")
@Transactional
public class CvDAOImpl extends GenericDAOImpl implements CvDAO{

}
