package com.mit.controler;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mit.entity.Projet;
import com.mit.entity.Tache;
import com.mit.entity.TacheId;
import com.mit.Modele.ProjetMod;
import com.mit.Modele.TacheMod;
import com.mit.dao.ProjetDAO;
import com.mit.dao.TacheDAO;


@Component("tacheBean")
@Scope("session")
@SessionScoped
public class TacheBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private static TacheMod tacheMod;
	private static ProjetMod projetMod;
	private Tache tache;
	private TacheId id;
	private Projet projet;
	private List<Tache> listTache;
	private List<Tache> taches;
	private Projet proj;
	private int t;
	private List<Tache>tachs;
	DateFormat dateFormat;
	String dat;
	
	@PostConstruct
	public void init(){
		context=new ClassPathXmlApplicationContext("application-context.xml");
		tacheMod= (TacheMod) context.getBean("tacheMod");
		projetMod=(ProjetMod) context.getBean("projetMod");
	//	projet=new Projet();
		id=new TacheId();
		tache=new Tache(id,projet);
		listTache=new ArrayList<Tache>();
		
		// condition de date 
		 dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  dat = dateFormat.format(new Date());
		  
	}
	
	
	public String convertir(Date d)
	{
		return String.valueOf(d);
	}
	
	
	
	
	public String getDat() {
		return dat;
	}





	public int getT() {
		return t;
	}



	public void setT(int t) {
		this.t = t;
	}



	public String ajouterTache()
	{
		try{
		
			projet=projetMod.filtrer( tache.getId().getIdProjet());
		/*	id.setIdProjet(projet.getIdProjet());
			id.setIdTache(tache.getId().getIdTache());
			tache.setId(id);*/
		//	projet=(Projet) projetDAO.findById(Projet.class, tache.getId().getIdProjet());
			tacheMod.ajouterTache(tache);
		//	projet=new Projet();
			id=new TacheId();
			tache=new Tache(id,projet);
		FacesContext.getCurrentInstance().addMessage
		(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"tache enregistrer",null));
		return "valide";
	} catch (Exception e) {
		FacesContext.getCurrentInstance().addMessage
		(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"erreur "+e.getMessage(),null));
		return "echec";
	}

		
	}

	public void onRowSelect(SelectEvent event)
	{
		taches=new ArrayList<Tache>();
		for(Tache t:this.getListTache())
		{
			if(((Projet)event.getObject()).getIdProjet().equals(t.getId().getIdProjet()))
			{
				taches.add(t);
			}
		}
		
	}
	
	
		
	public Tache getTache() {
		return tache;
	}


	public void setTache(Tache tache) {
		this.tache = tache;
	}


	public void delete (Tache tache)
	{
		tacheMod.supprimerTache(tache);
	}


	public List<Tache> getListTache() {
		listTache=tacheMod.consulterTache();
		return listTache;
	}


	public void setListTache(List<Tache> listTache) {
		this.listTache = listTache;
	}



	public List<Tache> getTaches() {
		return taches;
	}



	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}



	public Projet getProj() {
		return proj;
	}



	public void setProj(Projet proj) {
		this.proj = proj;
	}
	
	public Tache filter(int d)
	{
		TacheId i=new TacheId();
		i.setIdProjet(d);
		return tacheMod.filtrer(i);
	}
	
	
	public void lister()
	{
	
		
		projet=projetMod.filtrer(t);
		FacesContext.getCurrentInstance().addMessage
		(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"tache enregistrer"+t,null));
		System.out.println("jhg"+t);
		if( projet.getIdProjet() != null )
		{
			this.tachs=new ArrayList<Tache>();
		}
		for(Tache ta:this.getListTache())
		{
			if(projet.getIdProjet()==ta.getId().getIdProjet())
			{
				this.tachs.add(ta);
			}
			
		}
	}



	public List<Tache> getTachs() {
		return tachs;
	}



	public void setTachs(List<Tache> tachs) {
		this.tachs = tachs;
	}
	
	public void onCellEdit(CellEditEvent event) {
      //  Object oldValue = event.getOldValue();
        Tache newValue = (Tache) event.getNewValue();
         tacheMod.modifierTache(newValue);
//        if(newValue != null && !newValue.equals(oldValue)) {
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
    }
}
