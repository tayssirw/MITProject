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

import com.mit.Modele.ProjetMod;
import com.mit.Modele.TacheMod;
import com.mit.entity.Projet;
import com.mit.entity.Tache;


@Component("projetBean")
@SessionScoped
@Scope("session")
public class ProjetBean implements Serializable{


	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private ProjetMod projetMod;
	private Projet projet;
	private List<Projet> projets;
	private Projet proj,p;
	List<Tache> tachs;
	private TacheMod tache ;
	

	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		projetMod=(ProjetMod) context.getBean("projetMod");
		projet=new Projet();
		projets=new ArrayList<Projet>();
		tache=(TacheMod) context.getBean("tacheMod");
	}
	
	

	public List<Tache> getTachs() {
		return tachs;
	}



	public void setTachs(List<Tache> tachs) {
		this.tachs = tachs;
	}



	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}


	public List<Projet> getProjets() {
		projets=projetMod.consulterProj();
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	
	
	public Projet getProj() {
		return proj;
	}

	public void setProj(Projet proj) {
		this.proj = proj;
	}

	public String ajouterProjet()
	{
		try{
			projetMod.ajouterProj(projet);
			projet=new Projet();
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Projet Enregistrer",null));
			return "ajoute";
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"errer "+e.getMessage(),null));
			return "echec";
		}
	}
	
	public void delete(Projet projet)
	{
		projetMod.supprimerProj(projet);
		//init();
	
	}
	
	public Projet recherche(int p)
	{
		return projetMod.recherche(p);
	}
	
	public Projet filter(int p)
	{
		return projetMod.filtrer(p);
	}
	
	
//	public void lister()
//	{
//	
//		
//	//	p=projetMod.filtrer(projet.getIdProjet());
//		FacesContext.getCurrentInstance().addMessage
//		(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"tache enregistrer"+projet.getIdProjet(),null));
//	//	System.out.println("jhg"+t);
//		if( projet.getIdProjet() != null && projet.getIdProjet() !=0)
//		{
//			this.tachs=new ArrayList<Tache>();
//		}
//		for(Tache ta:tache.consulterTache())
//		{
//			if(projet.getIdProjet()==ta.getId().getIdProjet())
//			{
//				this.tachs.add(ta);
//			}
//			
//		}
//	}
//	

}
