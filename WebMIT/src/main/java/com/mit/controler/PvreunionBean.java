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

import com.mit.dao.PvreunionDAO;
import com.mit.entity.Contratmembre;
import com.mit.entity.Membre;
import com.mit.entity.Pvreunion;
import com.mit.entity.Tache;

@Component("pvreunionBean")
@SessionScoped
@Scope("session")
public class PvreunionBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private static PvreunionDAO pvreunionDao;
	private Pvreunion pvreunion;
	private List<Pvreunion> pvreunions ;
	private int id;
	private List<Membre>membres;
	
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		pvreunionDao=(PvreunionDAO) context.getBean("pvreunionDao");
		pvreunion=new Pvreunion();
		pvreunions=new ArrayList<Pvreunion>();
	}


	public Pvreunion getPvreunion() {
		return pvreunion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setPvreunion(Pvreunion pvreunion) {
		this.pvreunion = pvreunion;
	}


	@SuppressWarnings("unchecked")
	public List<Pvreunion> getPvreunions() {
		pvreunions=(List<Pvreunion>) pvreunionDao.findAll(Pvreunion.class);
		return pvreunions;
	}


	public void setPvreunions(List<Pvreunion> pvreunions) {
		this.pvreunions = pvreunions;
	}
	
	public void ajouterPv()
	{
		try{
			pvreunionDao.saveOrUpdate(pvreunion);
			pvreunion=new Pvreunion();
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Pv reunion creer",null));
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur "+e.getMessage(),null));
		}
	}
	
	public void delete(Pvreunion pvreunion)
	{
		pvreunionDao.delete(pvreunion);
	}
	

	
	public void lister()
	{
	
		
		TacheBean b=new TacheBean();
		Tache tache=b.filter(id);
		ContratMembreBean c=new ContratMembreBean();
		if(tache.getId().getIdProjet()!= 0 )
		{
			this.membres=new ArrayList<>();
		}
		for(Contratmembre con:c.getContrats())
		{
			
			if(id==con.getId().getIdProjet())
			{
				this.membres.add(con.getMembre());
			}
			
		}
		
		
	}

}
