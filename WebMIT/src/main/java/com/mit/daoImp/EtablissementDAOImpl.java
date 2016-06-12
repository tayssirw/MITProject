package com.mit.daoImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.EtablissementDAO;

@Repository("etablissementDao")
@Transactional
public class EtablissementDAOImpl extends GenericDAOImpl implements EtablissementDAO{

}
