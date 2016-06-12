package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.ContratSocMod;
import com.mit.dao.ContratSocieteDAO;
import com.mit.entity.Contratsociete;
import com.mit.entity.ContratsocieteId;

@Transactional
@Service("contratSocMod")
public class ContratSocModImpl implements ContratSocMod{

	@Autowired
	private ContratSocieteDAO contSocDao;
	private Contratsociete contSoc=new Contratsociete();
	
	
	public Contratsociete getContSoc() {
		return contSoc;
	}

	public void setContSoc(Contratsociete contSoc) {
		this.contSoc = contSoc;
	}

	@Override
	public void ajouterContrat(Contratsociete  c) {
		contSocDao.saveOrUpdate(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierContrat(Contratsociete c) {
		contSocDao.saveOrUpdate(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerContrat(Contratsociete c) {
		contSocDao.delete(c);
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contratsociete> consulterContrat() {
		// TODO Auto-generated method stub
		return (List<Contratsociete>) contSocDao.findAll(Contratsociete.class);
	}

	@Override
	public Contratsociete filtrer(ContratsocieteId id) {
		// TODO Auto-generated method stub
		return (Contratsociete) contSocDao.findById(Contratsociete.class, id);
	}

	@Override
	public Contratsociete recherche(ContratsocieteId id) {
		// TODO Auto-generated method stub
		return (Contratsociete) contSocDao.findBy(Contratsociete.class, id);
	}

}
