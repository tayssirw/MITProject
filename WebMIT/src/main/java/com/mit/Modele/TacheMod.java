package com.mit.Modele;

import java.util.List;

import com.mit.entity.Tache;
import com.mit.entity.TacheId;

public interface TacheMod {
	public void ajouterTache(Tache t);
	public void modifierTache(Tache t);
	public void supprimerTache(Tache t);
	public List<Tache> consulterTache();
	public Tache filtrer(TacheId id);
	public Tache recherche(TacheId id);


}
