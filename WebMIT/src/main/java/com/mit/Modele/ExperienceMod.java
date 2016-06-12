package com.mit.Modele;

import java.util.List;

import com.mit.entity.Experience;;

public interface ExperienceMod {
	public void ajouterExp(Experience e);
	public void modifierExp(Experience e);
	public void supprimerExp(Experience e);
	public List<Experience> consulterExp();
	public Experience filtrer(int id);
	public Experience recherche(int id);


}
