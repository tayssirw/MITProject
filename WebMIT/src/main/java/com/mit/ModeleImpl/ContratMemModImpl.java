package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.ContratMembreMod;
import com.mit.dao.ContratMembreDAO;
import com.mit.entity.Contrat;
import com.mit.entity.Contratmembre;
import com.mit.entity.ContratmembreId;

@Transactional
@Service("contratMemMod")
public class ContratMemModImpl implements ContratMembreMod{
	@Autowired
	private ContratMembreDAO conMemDao;
	private Contratmembre contMemb=new Contratmembre();
	
	

	public Contratmembre getContMemb() {
		return contMemb;
	}

	public void setContMemb(Contratmembre contMemb) {
		this.contMemb = contMemb;
	}

	@Override
	public void ajouterContrat(Contratmembre c) {
		conMemDao.saveOrUpdate(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierContrat(Contratmembre c) {
		conMemDao.saveOrUpdate(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerContrat(Contratmembre c) {
		conMemDao.delete(c);
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contratmembre> consulterContrat() {
		// TODO Auto-generated method stub
		return (List<Contratmembre>) conMemDao.findAll(Contratmembre.class);
	}

	@Override
	public Contratmembre filtrer(ContratmembreId id) {
		// TODO Auto-generated method stub
		return (Contratmembre) conMemDao.findById(Contratmembre.class, id);
	}

	@Override
	public Contratmembre recherche(ContratmembreId id) {
		// TODO Auto-generated method stub
		return (Contratmembre) conMemDao.findBy(Contratmembre.class, id);
	}

}
