package com.mit.ModeleImpl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.MembreMod;
import com.mit.dao.MembreDAO;
import com.mit.entity.Membre;

@Transactional
@Service("membreMod")
public class MembreModImpl implements MembreMod{
	//private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	@Autowired
	private MembreDAO memDao;
	//=(MembreDAO) context.getBean("membreDao");
	private Membre membre=new Membre();
	
	

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	@Override
	public void ajouterMembre(Membre m) {
		// TODO Auto-generated method stub
		memDao.saveOrUpdate(m);
		
	}

	@Override
	public void modifierMemre(Membre m) {
		// TODO Auto-generated method stub
		memDao.saveOrUpdate(m);
		
	}

	@Override
	public void supprimerMembre(Membre m) {
		// TODO Auto-generated method stub
		memDao.delete(m);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Membre> consulterMembre() {
		// TODO Auto-generated method stub
		return (List<Membre>) memDao.findAll(Membre.class);
	}

	@Override
	public Membre filtrer(int id) {
		// TODO Auto-generated method stub
		return (Membre) memDao.findById(Membre.class, id);
	}

	@Override
	public Membre recherche(int id) {
		// TODO Auto-generated method stub
		return (Membre) memDao.findBy(Membre.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Membre authentifier(Criterion critere1, Criterion critere2) {
		// TODO Auto-generated method stub
		return (Membre) memDao.loginMembre(Membre.class, critere1, critere2);
	}

	@Override
	public Membre authentifier(String email, String password) {
		// TODO Auto-generated method stub
		return memDao.login(email, password);
	}
	

}
