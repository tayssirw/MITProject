package com.mit.controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mit.Modele.ContratMembreMod;
import com.mit.entity.Contratmembre;

@SessionScoped
@Scope("session")
@Component("contratMembBean")
public class ContratMembreBean implements Serializable{
	
	private ClassPathXmlApplicationContext context ;
	private Contratmembre m;
	private ContratMembreMod conMod;
	private List<Contratmembre> contrats;
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		m=new Contratmembre();
		conMod=(ContratMembreMod) context.getBean("contratMemMod");
		contrats=new ArrayList<Contratmembre>();
	}

	
	public List<Contratmembre> getContrats() {
		contrats=conMod.consulterContrat();
		return contrats;
	}


	public void setContrats(List<Contratmembre> contrats) {
		this.contrats = contrats;
	}


	public Contratmembre getM() {
		return m;
	}

	public void setM(Contratmembre m) {
		this.m = m;
	}
	
	public void ajouterConMemb()
	{
		try{
		conMod.ajouterContrat(m);
		m=new Contratmembre();
		}catch(Exception e)
		{
			
		}
	}
	
	

}
