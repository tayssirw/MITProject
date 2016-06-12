package com.mit.Modele;

import java.util.List;

import com.mit.entity.Etablissement;;

public interface EtablissementMod {
	public void ajouterEtab(Etablissement e);
	public void modifierEtab(Etablissement e);
	public void supprimerEtab(Etablissement e);
	public List<Etablissement> consulterCv();
	public Etablissement filtrer(int id);
	public Etablissement recherche(int id);


}
