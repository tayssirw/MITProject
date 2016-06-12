package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.TacheMod;
import com.mit.dao.TacheDAO;
import com.mit.entity.Tache;
import com.mit.entity.TacheId;

@Transactional
@Service("tacheMod")
public class TacheModImpl implements TacheMod{

//	private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	@Autowired
	private TacheDAO tacheDao;
	//=(TacheDAO) context.getBean("tacheDao");
	private Tache tach=new Tache();
	
	
	public Tache getTach() {
		return tach;
	}

	public void setTach(Tache tach) {
		this.tach = tach;
	}
	
	@Override
	public void ajouterTache(Tache t) {
		// TODO Auto-generated method stub
		tacheDao.saveOrUpdate(t);
	}

	@Override
	public void modifierTache(Tache t) {
		// TODO Auto-generated method stub
		tacheDao.saveOrUpdate(t);
	}

	@Override
	public void supprimerTache(Tache t) {
		// TODO Auto-generated method stub
		tacheDao.delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tache> consulterTache() {
		// TODO Auto-generated method stub
		return (List<Tache>) tacheDao.findAll(Tache.class);
	}

	@Override
	public Tache filtrer(TacheId id) {
		// TODO Auto-generated method stub
		return (Tache) tacheDao.findById(Tache.class, id);
	}

	@Override
	public Tache recherche(TacheId id) {
		// TODO Auto-generated method stub
		return (Tache) tacheDao.findBy(Tache.class, id);
	}

}
