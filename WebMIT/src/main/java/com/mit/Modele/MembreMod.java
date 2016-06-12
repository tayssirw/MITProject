package com.mit.Modele;

import java.util.List;



import org.hibernate.criterion.Criterion;

import com.mit.entity.Membre;

public interface MembreMod {

	public void ajouterMembre(Membre m);
	public void modifierMemre(Membre m);
	public void supprimerMembre(Membre m);
	public List<Membre> consulterMembre();
	public Membre filtrer(int id);
	public Membre recherche(int id);
	public Membre authentifier( Criterion critere1, Criterion critere2);
	public Membre authentifier(String email, String password); 
}
