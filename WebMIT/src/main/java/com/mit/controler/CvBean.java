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
import com.mit.Modele.CvMod;
import com.mit.dao.CvDAO;
import com.mit.entity.Competance;
import com.mit.entity.Cv;

@Component("cvBean")
@SessionScoped
@Scope("session")
public class CvBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private CvMod cvMod;
	private Cv cv;
	private List<Cv> cvs;
	private CompetanceMod competanceMod;
	private Competance competance;
	private List<Competance>competances;
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		cvMod=(CvMod) context.getBean("cvMod");
		cv=new Cv();
		cvs=new ArrayList<Cv>();
		competanceMod=(CompetanceMod) context.getBean("compMod");
		competance=new Competance();
		competances=new ArrayList<Competance>();
		
	}


	public Cv getCv() {
		return cv;
	}


	public void setCv(Cv cv) {
		this.cv = cv;
	}
	


	public List<Competance> getCompetances() {
		competanceMod.consulterComp();
		return competances;
	}
	
//	public List<Competance> consulter()
//	{
//		for(Competance c: this.getCompetances())
//		{
//			if(c.)
//		}
//	}


	public void setCompetances(List<Competance> competances) {
		this.competances = competances;
	}


	public List<Cv> getCvs() {
//		cvs.iterator().next().setCompetances(cv.getCompetances());
		cvs=cvMod.consulterCv();
		return cvs;
	}


	public void setCvs(List<Cv> cvs) {
		this.cvs = cvs;
	}
	
	public void ajouterCv()
	{
		try{
			cvMod.ajouterCv(cv);
			cv=new Cv();
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cv Enregistrer",null));
			
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur "+e.getMessage(),null));
		}
	}
	
	
	public void deleteCv(Cv cv)
	{
		cvMod.supprimerCv(cv);
	}

}
