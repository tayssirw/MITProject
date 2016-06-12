package com.mit.daoImp;


import com.mit.dao.TacheDAO;

import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Repository("tacheDao")
@Repository("tacheDao")
@Transactional
public class TacheDAOImpl extends GenericDAOImpl implements TacheDAO{
	
//	public List<Tache> findList(Serializable id,Serializable id2)
//	{
//		List<Tache> list = new ArrayList<Tache>();
//		Query query =  sessionFactory.getCurrentSession().createQuery("select idTache from Contrat where idMembre="+id+" and idProjet="+id2);
//		list = query.list();
//		return list;
//	}
	

	}
