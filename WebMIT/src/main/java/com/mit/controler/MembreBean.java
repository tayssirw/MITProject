package com.mit.controler;

import java.io.Serializable;




import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mit.Modele.MembreMod;
import com.mit.entity.Membre;

@Component("membreBean")
@Scope("session")
@SessionScoped
public class MembreBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private  MembreMod membreMod;
	private Membre membre;
	private List<Membre> membres; 
	private List<Membre> listMembre; 
	private Membre m;
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		membreMod=(MembreMod) context.getBean("membreMod");
		membre=new Membre();
		membres=new ArrayList<Membre>();
	}
	
	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	 
	public Membre getM() {
		return m;
	}

	public void setM(Membre m) {
		this.m = m;
	}

	public String ajouterMembre()
	{
		try{
		//	membre=new Membre()
			membreMod.ajouterMembre(membre);
			m=membre;
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"bienvenu "+membre.getNom()+" "+membre.getPrenom(),null));
			membre=new Membre();
			return "ajouter";
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur "+e.getMessage()+e.toString(),null));
			return "echec";
		}
	}
	
	
	public void delete(Membre membre)
	{
		membreMod.supprimerMembre(membre);
	}

	
	
	public List<Membre> getMembres() {
		membres=membreMod.consulterMembre();
		return membres;
	}

	public void setMembres(List<Membre> membres) {
		this.membres = membres;
	}

	public List<Membre> getListMembre() {
		return listMembre;
	}

	public void setListMembre(List<Membre> listMembre) {
		this.listMembre = listMembre;
	}
	
	public void Modifier()
	{
		try{
			
				membreMod.modifierMemre(membre);
				FacesContext.getCurrentInstance().addMessage
				(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"les modifications sont effectier",null));
			}catch(Exception e)
			{
				FacesContext.getCurrentInstance().addMessage
				(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur "+e.getMessage()+e.toString(),null));
			}
	}

	
}
