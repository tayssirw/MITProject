package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.EtablissementMod;
import com.mit.dao.EtablissementDAO;
import com.mit.entity.Etablissement;

@Transactional
@Service("etabMod")
public class EtablissementModImpl implements EtablissementMod {
	
	//private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	@Autowired
	private EtablissementDAO etabDao;
	//=(EtablissementDAO) context.getBean("etablissementDao");
	private Etablissement etab=new Etablissement();
	
	

	public Etablissement getEtab() {
		return etab;
	}

	public void setEtab(Etablissement etab) {
		this.etab = etab;
	}

	@Override
	public void ajouterEtab(Etablissement e) {
		etabDao.saveOrUpdate(e);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierEtab(Etablissement e) {
		etabDao.saveOrUpdate(e);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerEtab(Etablissement e) {
		etabDao.delete(e);
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etablissement> consulterCv() {
		// TODO Auto-generated method stub
		return (List<Etablissement>) etabDao.findAll(Etablissement.class);
	}

	@Override
	public Etablissement filtrer(int id) {
		// TODO Auto-generated method stub
		return (Etablissement) etabDao.findById(Etablissement.class, id);
	}

	@Override
	public Etablissement recherche(int id) {
		// TODO Auto-generated method stub
		return (Etablissement) etabDao.findBy(Etablissement.class, id);
	}

}
