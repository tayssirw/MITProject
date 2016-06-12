package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.SocieteMod;
import com.mit.dao.SocieteDAO;
import com.mit.entity.Societe;

@Transactional
@Service("societeMod")
public class SocieteModImp implements SocieteMod {

//	private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	@Autowired
	private SocieteDAO societeDao;
	//=(SocieteDAO) context.getBean("societeDao");
	private Societe soc=new Societe();
	
	public Societe getSoc() {
		return soc;
	}

	public void setSoc(Societe soc) {
		this.soc = soc;
	}

	@Override
	public void ajouterSociete(Societe s) {
		societeDao.saveOrUpdate(s);
		
	}

	@Override
	public void modifierSociete(Societe s) {
		// TODO Auto-generated method stub
		societeDao.saveOrUpdate(s);
	}

	@Override
	public void supprimerSociete(Societe s) {
		// TODO Auto-generated method stub
		societeDao.delete(s);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Societe> consulterSoc() {
		// TODO Auto-generated method stub
		return (List<Societe>) societeDao.findAll(Societe.class);
	}

	@Override
	public Societe filtrer(int id) {
		// TODO Auto-generated method stub
		return (Societe) societeDao.findById(Societe.class, id);
	}

	@Override
	public Societe recherche(int id) {
		// TODO Auto-generated method stub
		return (Societe) societeDao.findBy(Societe.class, id);
	}

}
