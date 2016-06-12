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

import com.mit.Modele.CompetanceMod;
import com.mit.dao.CompetanceDAO;
import com.mit.entity.Competance;

@Component("competanceBean")
@SessionScoped
@Scope("session")
public class CompetanceBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private CompetanceMod competanceMod;
	private Competance competance;
	private List<Competance>competances;
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		competanceMod=(CompetanceMod) context.getBean("compMod");
		competance=new Competance();
		competances=new ArrayList<Competance>();
	}

	public Competance getCompetance() {
		return competance;
	}

	public void setCompetance(Competance competance) {
		this.competance = competance;
	}

	public List<Competance> getCompetances() {
		competances=competanceMod.consulterComp();
		return competances;
	}

	public void setCompetances(List<Competance> competances) {
		this.competances = competances;
	}

	public void ajouterComp()
	{
		try{
			competanceMod.ajouterComp(competance);
			competance=new Competance();
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ajouter competance", null));
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"erreur "+e.getMessage(), null));
		}
	}
}
