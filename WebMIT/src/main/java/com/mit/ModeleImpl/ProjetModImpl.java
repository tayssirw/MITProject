package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.ProjetMod;
import com.mit.dao.ProjetDAO;
import com.mit.entity.Projet;

@Transactional
@Service("projetMod")
public class ProjetModImpl implements ProjetMod{
	//private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	@Autowired
	private ProjetDAO projetDao;
	//=(ProjetDAO) context.getBean("projetDao");
	private Projet proj=new Projet();
	
	
	
	public Projet getProj() {
		return proj;
	}

	public void setProj(Projet proj) {
		this.proj = proj;
	}

	@Override
	public void ajouterProj(Projet p) {
		projetDao.saveOrUpdate(p);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierProj(Projet p) {
		projetDao.saveOrUpdate(p);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerProj(Projet p) {
		projetDao.delete(p);
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projet> consulterProj() {
		// TODO Auto-generated method stub
		return (List<Projet>) projetDao.findAll(Projet.class);
	}

	@Override
	public Projet filtrer(int id) {
		// TODO Auto-generated method stub
		return (Projet) projetDao.findById(Projet.class, id);
	}

	@Override
	public Projet recherche(int id) {
		// TODO Auto-generated method stub
		return (Projet) projetDao.findBy(Projet.class, id);
	}


}
