package com.mit.Modele;

import java.util.List;

import com.mit.entity.Societe;;

public interface SocieteMod {
	public void ajouterSociete(Societe s);
	public void modifierSociete(Societe s);
	public void supprimerSociete(Societe s);
	public List<Societe> consulterSoc();
	public Societe filtrer(int id);
	public Societe recherche(int id);


}
