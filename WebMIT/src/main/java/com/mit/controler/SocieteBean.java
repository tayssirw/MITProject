package com.mit.controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mit.Modele.SocieteMod;
import com.mit.dao.SocieteDAO;
import com.mit.entity.Societe;

@Component("societeBean")
@SessionScoped
@Scope("session")
public class SocieteBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private SocieteMod societeMod;
	private Societe societe;
	private List<Societe> societes;
	private List<Societe> listFilter;
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		societeMod=(SocieteMod) context.getBean("societeMod");
		societe=new Societe();
		societes=new ArrayList<Societe>();
	}
	
	

	public List<Societe> getListFilter() {
		return listFilter;
	}



	public void setListFilter(List<Societe> listFilter) {
		this.listFilter = listFilter;
	}



	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}


	public List<Societe> getSocietes() {
		societes=societeMod.consulterSoc();
		return societes;
	}

	public void setSocietes(List<Societe> societes) {
		this.societes = societes;
	}
	
	public void ajouterSociete()
	{
		try{
			societeMod.ajouterSociete(societe);
			societe=new Societe();
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Societe Enregistrer",null));
			
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "erreur "+e.getMessage(), null));
		}
	}
	
	public void deleteSociete(Societe societe)
	{
		societeMod.supprimerSociete(societe);
	}
	public Societe recherche(int s)
	{
		return societeMod.recherche(s);
	}
	
	public void chooseCar() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog("ModifierSociete", options, null);
    }
	
	public Societe filter(int s)
	{
		return societeMod.filtrer(s);
	}
}



