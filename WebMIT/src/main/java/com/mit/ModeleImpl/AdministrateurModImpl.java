package com.mit.ModeleImpl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.AdministrateurMod;
import com.mit.dao.AdministrateurDAO;
import com.mit.entity.Administrateur;

@Transactional
@Service("AdminMod")
public class AdministrateurModImpl implements AdministrateurMod{
	
	@Autowired
	private AdministrateurDAO adminDao;

	@Override
	public void AjouterAdmin(Administrateur a) {
		adminDao.saveOrUpdate(a);
		
	}

	@Override
	public void ModifierAdmin(Administrateur a) {
		// TODO Auto-generated method stub
		adminDao.saveOrUpdate(a);
		
	}

	@Override
	public void SupprimerAdmin(Administrateur a) {
		adminDao.delete(a);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrateur> consulterAdmin() {
		// TODO Auto-generated method stub
		return (List<Administrateur>) adminDao.findAll(Administrateur.class);
	}

	@Override
	public Administrateur filtre(String id) {
		// TODO Auto-generated method stub
		return (Administrateur) adminDao.findById(Administrateur.class, id);
	}

	@Override
	public Administrateur recherche(String id) {
		// TODO Auto-generated method stub
		return (Administrateur) adminDao.findBy(Administrateur.class, id);
	}

	@Override
	public Administrateur authentifier(Criterion critere1,
			Criterion critere2) {
		// TODO Auto-generated method stub
		return (Administrateur) adminDao.loginAdmin(Administrateur.class, critere1, critere2);
	}

	@Override
	public Administrateur authentifier(String login, String password) {
		// TODO Auto-generated method stub
		return adminDao.login(login, password);
	}

}
