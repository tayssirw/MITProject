package com.mit.Modele;

import java.util.List;

import com.mit.entity.Diplome;;

public interface DiplomeMod {
	
	public void ajouterDip(Diplome d);
	public void modifierDip(Diplome d);
	public void supprimerDip(Diplome d);
	public List<Diplome> consulterDip();
	public Diplome filtrer(int id);
	public Diplome recherche(int id);


}
