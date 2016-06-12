package com.mit.Modele;

import java.util.List;

import com.mit.entity.Competance;

public interface CompetanceMod {
	public void ajouterComp(Competance c);
	public void modifierComp(Competance c);
	public void supprimerComp(Competance c);
	public List<Competance> consulterComp();
	public Competance filtrer(int id);
	public Competance recherche(int id);

}
