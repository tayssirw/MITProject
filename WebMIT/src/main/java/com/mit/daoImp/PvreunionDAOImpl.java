package com.mit.daoImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.PvreunionDAO;

@Repository("pvreunionDao")
@Transactional
public class PvreunionDAOImpl extends GenericDAOImpl implements PvreunionDAO{

}
