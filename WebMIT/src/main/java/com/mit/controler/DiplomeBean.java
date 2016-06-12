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

import com.mit.Modele.DiplomeMod;
import com.mit.Modele.EtablissementMod;
import com.mit.dao.DiplomeDAO;
import com.mit.entity.Diplome;
import com.mit.entity.Etablissement;

@Component("diplomeBean")
@SessionScoped
@Scope("session")
public class DiplomeBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context ;
	private EtablissementMod etabMod ;
	private Etablissement etab;
	private DiplomeMod diplomeMod;
	private Diplome diplome;
	private List<Diplome>diplomes;
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		diplomeMod=(DiplomeMod) context.getBean("dipMod");
	//	etabMod=(EtablissementMod) context.getBean("etabMod");
	//	etab=new Etablissement();
		diplome=new Diplome();
		diplomes=new ArrayList<Diplome>();
	}
	
	

//	public Etablissement getEtab() {
//		return etab;
//	}
//
//
//
//	public void setEtab(Etablissement etab) {
//		this.etab = etab;
//	}



	public Diplome getDiplome() {
		return diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}
	
	
	public List<Diplome> getDiplomes() {
		diplomes=diplomeMod.consulterDip();
		return diplomes;
	}

	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}
	
	public void ajouterDiplome(Etablissement etab)
	{
		try{
			
			diplome.setEtablissement(etab);
			diplomeMod.ajouterDip(diplome);
			diplome=new Diplome();
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ajouter diplome ",null));
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur "+e.getMessage(),null));
		}
	}
	
	public void deleteDiplome(Diplome diplome)
	{
		diplomeMod.supprimerDip(diplome);
	}

	public void ajouterEtab()
	{
		try{
			etabMod.ajouterEtab(etab);
			etab=new Etablissement();
//			FacesContext.getCurrentInstance().addMessage
//			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"etablissement creer", null));
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur "+e.getMessage(),null));
		}
	}
}
