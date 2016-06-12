package com.mit.Modele;

import java.util.List;

import com.mit.entity.Pvreunion;;

public interface PvMod {
	public void ajouterPv(Pvreunion p);
	public void modifierPv(Pvreunion p);
	public void supprimerPv(Pvreunion p);
	public List<Pvreunion> consulterPv();
	public Pvreunion filtrer(int id);
	public Pvreunion recherche(int id);


}
