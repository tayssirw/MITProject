package com.mit.Modele;

import java.util.List;

import com.mit.entity.Attestation;
import com.mit.entity.AttestationId;

public interface AttestationMod {
	public void ajouterAttest(Attestation a);
	public void modifierAttest(Attestation a);
	public void supprimerAttest(Attestation a);
	public List<Attestation> consulterAttest();
	public Attestation filtrer(AttestationId id);
	public Attestation recherche(AttestationId id);

}
