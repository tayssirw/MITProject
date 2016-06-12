package com.mit.daoImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mit.dao.ExperienceDAO;

@Repository("experienceDao")
@Transactional
public class ExperienceDAOImpl extends GenericDAOImpl implements ExperienceDAO {

}
