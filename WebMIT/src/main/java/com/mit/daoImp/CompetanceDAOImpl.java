package com.mit.daoImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.CompetanceDAO;

@Repository("competanceDao")
@Transactional
public class CompetanceDAOImpl extends GenericDAOImpl implements CompetanceDAO {

}
