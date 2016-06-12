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

import com.mit.Modele.ExperienceMod;
import com.mit.dao.ExperienceDAO;
import com.mit.entity.Experience;

@Component("experienceBean")
@SessionScoped
@Scope("session")
public class ExperienceBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private ExperienceMod expMod;
	private Experience experience;
	private List<Experience>experiences;
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		expMod=(ExperienceMod) context.getBean("expMod");
		experience=new Experience();
		experiences=new ArrayList<Experience>();
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	
	public List<Experience> getExperiences() {
		experiences=expMod.consulterExp();
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
	
	public void ajouterExperience()
	{
		try{
			expMod.ajouterExp(experience);
			experience=new Experience();
			FacesContext.getCurrentInstance().addMessage
			(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Experience crrer", null));
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "erreur "+e.getMessage(), null));
			
		}
	}
	
	public void deleteExperience(Experience experience)
	{
		expMod.supprimerExp(experience);
	}

}
