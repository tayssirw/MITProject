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

import com.mit.Modele.EtablissementMod;
import com.mit.dao.EtablissementDAO;
import com.mit.entity.Etablissement;


@Component("etablissementBean")
@SessionScoped
@Scope("session")
public class EtablissementBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private EtablissementMod etabMod ;
	private Etablissement etab;
	private List<Etablissement>etabs;
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		etabMod=(EtablissementMod) context.getBean("etabMod");
		etab=new Etablissement();
		etabs=new ArrayList<Etablissement>();
	}

	public Etablissement getEtab() {
		return etab;
	}

	public void setEtab(Etablissement etab) {
		this.etab = etab;
	}

	public List<Etablissement> getEtabs() {
		etabs=etabMod.consulterCv();
		return etabs;
	}

	public void setEtabs(List<Etablissement> etabs) {
		this.etabs = etabs;
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
	
	public void deleteEtab(Etablissement etab)
	{
		etabMod.supprimerEtab(etab);
	}
		

}
