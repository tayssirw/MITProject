package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.CompetanceMod;
import com.mit.dao.CompetanceDAO;
import com.mit.entity.Competance;

@Transactional
@Service("compMod")
public class CompetenceModImpl implements CompetanceMod{
	
//	private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	
	@Autowired
	CompetanceDAO compDao;
	//=(CompetanceDAO) context.getBean("competenceDao");
	Competance comp=new Competance();
	
	

	public Competance getComp() {
		return comp;
	}

	public void setComp(Competance comp) {
		this.comp = comp;
	}

	@Override
	public void ajouterComp(Competance c) {
		compDao.saveOrUpdate(c);
		
	}

	@Override
	public void modifierComp(Competance c) {
		compDao.saveOrUpdate(c);
		
	}

	@Override
	public void supprimerComp(Competance c) {
		compDao.delete(c);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Competance> consulterComp() {
		// TODO Auto-generated method stub
		return (List<Competance>) compDao.findAll(Competance.class);
	}

	@Override
	public Competance filtrer(int id) {
		// TODO Auto-generated method stub
		return (Competance) compDao.findById(Competance.class, id);
	}

	@Override
	public Competance recherche(int id) {
		// TODO Auto-generated method stub
		return (Competance) compDao.findBy(Competance.class, id);
	}

}
