package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.DiplomeMod;
import com.mit.dao.DiplomeDAO;
import com.mit.entity.Diplome;

@Transactional
@Service("dipMod")
public class DiplomeModImpl implements DiplomeMod{
	
//	private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	@Autowired
	DiplomeDAO diplomeDao;
	//=(DiplomeDAO) context.getBean("diplomeDao");
	Diplome dip=new Diplome();
	
	

	public Diplome getDip() {
		return dip;
	}

	public void setDip(Diplome dip) {
		this.dip = dip;
	}

	@Override
	public void ajouterDip(Diplome d) {
		// TODO Auto-generated method stub
		diplomeDao.saveOrUpdate(d);
		
	}

	@Override
	public void modifierDip(Diplome d) {
		// TODO Auto-generated method stub
		diplomeDao.saveOrUpdate(d);
		
	}

	@Override
	public void supprimerDip(Diplome d) {
		// TODO Auto-generated method stub
		diplomeDao.delete(d);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Diplome> consulterDip() {
		// TODO Auto-generated method stub
		return (List<Diplome>) diplomeDao.findAll(Diplome.class);
	}

	@Override
	public Diplome filtrer(int id) {
		// TODO Auto-generated method stub
		return (Diplome) diplomeDao.findById(Diplome.class, id);
	}

	@Override
	public Diplome recherche(int id) {
		// TODO Auto-generated method stub
		return (Diplome) diplomeDao.findBy(Diplome.class, id);
	}

}
