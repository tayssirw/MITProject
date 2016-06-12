package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.AttestationMod;
import com.mit.dao.AttestationDAO;
import com.mit.entity.Attestation;
import com.mit.entity.AttestationId;

@Service("attestationMod")
@Transactional
public class AttestationModImpl implements AttestationMod{

	@Autowired
	private AttestationDAO attestationDao;
	
	
	

	@Override
	public void ajouterAttest(Attestation a) {
		attestationDao.saveOrUpdate(a);
	}

	@Override
	public void modifierAttest(Attestation a) {
		attestationDao.saveOrUpdate(a);
		
	}

	@Override
	public void supprimerAttest(Attestation a) {
		attestationDao.delete(a);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attestation> consulterAttest() {
		return (List<Attestation>) attestationDao.findAll(Attestation.class);
	}

	@Override
	public Attestation filtrer(AttestationId id) {
		return (Attestation) attestationDao.findById(Attestation.class, id);
	}

	@Override
	public Attestation recherche(AttestationId id) {
		return (Attestation) attestationDao.findBy(Attestation.class, id);
	}

}
