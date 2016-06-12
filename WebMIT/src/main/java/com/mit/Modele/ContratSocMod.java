package com.mit.Modele;

import java.util.List;

import com.mit.entity.Contratsociete;
import com.mit.entity.ContratsocieteId;

public interface ContratSocMod {
	public void ajouterContrat(Contratsociete c);
	public void modifierContrat(Contratsociete c);
	public void supprimerContrat(Contratsociete c);
	public List<Contratsociete> consulterContrat();
	public Contratsociete filtrer(ContratsocieteId id);
	public Contratsociete recherche(ContratsocieteId id);

}
