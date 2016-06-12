package com.mit.Modele;

import java.util.List;

import com.mit.entity.Projet;

public interface ProjetMod {
	public void ajouterProj(Projet p);
	public void modifierProj(Projet p);
	public void supprimerProj(Projet p);
	public List<Projet> consulterProj();
	public Projet filtrer(int id);
	public Projet recherche(int id);


}
