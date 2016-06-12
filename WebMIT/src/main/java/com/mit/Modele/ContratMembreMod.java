package com.mit.Modele;


import java.util.List;

import com.mit.entity.Contratmembre;
import com.mit.entity.ContratmembreId;

public interface ContratMembreMod {

	public void ajouterContrat(Contratmembre c);
	public void modifierContrat(Contratmembre c);
	public void supprimerContrat(Contratmembre c);
	public List<Contratmembre> consulterContrat();
	public Contratmembre filtrer(ContratmembreId id);
	public Contratmembre recherche(ContratmembreId id);
}
