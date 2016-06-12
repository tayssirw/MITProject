package com.mit.Modele;

import java.util.List;



import org.hibernate.criterion.Criterion;

import com.mit.entity.Administrateur;

public interface AdministrateurMod {
	public void AjouterAdmin(Administrateur a);
	public void ModifierAdmin(Administrateur a);
	public void  SupprimerAdmin(Administrateur a);
	public List<Administrateur> consulterAdmin();
	public Administrateur filtre(String id);
	public Administrateur recherche(String id);
	public Administrateur authentifier( Criterion critere1, Criterion critere2);
	public Administrateur authentifier(String login, String password );



}
