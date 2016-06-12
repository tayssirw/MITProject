package com.mit.Modele;

import java.util.List;


import com.mit.entity.Cv;

public interface CvMod {
	public void ajouterCv(Cv c);
	public void modifierCv(Cv c);
	public void supprimerCv(Cv c);
	public List<Cv> consulterCv();
	public Cv filtrer(int id);
	public Cv recherche(int id);

}
