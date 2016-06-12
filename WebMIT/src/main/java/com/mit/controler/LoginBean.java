package com.mit.controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mit.Modele.AdministrateurMod;
import com.mit.Modele.MembreMod;
import com.mit.entity.Administrateur;
import com.mit.entity.Membre;

@Component("loginBean")
@Scope("session")
@SessionScoped
public class LoginBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private String username;
	private String password;
	private MembreMod membreMod;
	private AdministrateurMod adminMod;
	private List<Membre> membres;
	private List<Administrateur> administrateurs;
	private Membre membre;
	private Administrateur admin;
	
	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		membreMod=(MembreMod) context.getBean("membreMod");
		adminMod=(AdministrateurMod) context.getBean("AdminMod");
		membres=new ArrayList<Membre>();
		administrateurs=new ArrayList<Administrateur>();
		username="";
		password="";
		membre=new Membre();
		admin=new Administrateur();
	}
	
	
	
	
	public Membre getMembre() {
		return membre;
	}




	public void setMembre(Membre membre) {
		this.membre = membre;
	}




	public Administrateur getAdmin() {
		return admin;
	}




	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public List<Membre> getMembres() {
		membres=membreMod.consulterMembre();
		return membres;
	}




	public void setMembres(List<Membre> membres) {
		this.membres = membres;
	}




	public List<Administrateur> getAdministrateurs() {
		administrateurs=adminMod.consulterAdmin();
		return administrateurs;
	}




	public void setAdministrateurs(List<Administrateur> administrateurs) {
		this.administrateurs = administrateurs;
	}




	public String connecter()
	{
		for(Membre m :membres)
		{
			if(m.getEmail().equals(username) && m.getPassword().equals(password))
			{
				this.setMembre(m);
				return "membre";
			}
		}
		for(Administrateur a:administrateurs)
		{
			if(a.getUsername().equals(username) && a.getPassword().equals(password))
			{
				this.setAdmin(a);
				return "administrateur";
			}
		}
		
		return "echec";
	}
	
	public String authentifier()
	{
		Criterion	c1= Restrictions.eq("email", username);
		Criterion	c2= Restrictions.eq("password", password);
		Membre resm=membreMod.authentifier(c1,c2);
		Criterion c3= Restrictions.eq("username", username);
		Criterion c4= Restrictions.eq("password", password);
		Administrateur resa= adminMod.authentifier(c3, c4);
		if(resm.getEmail()!=null)
		{
			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session=(HttpSession) context.getExternalContext().getSession(true);//true
			session.setAttribute("membre", resm);
			username="";
			password="";
			return "membre";
		}
		else if(resa.getUsername()!=null)
		{
			FacesContext context=FacesContext.getCurrentInstance();
			HttpSession session= 
					(HttpSession) context.getExternalContext().getSession(true);//true
			session.setAttribute("admin", resa);
			username="";
			password="";
			return "admin";
		}
		return "echec";
	}
	
	public String logout()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session =(HttpSession) context.getExternalContext().getSession(true);
		session.invalidate();
		return "echec";
	}
	
//	public String login()
//	{
//		Criterion c1;
//		Criterion c2;
//		c1= Restrictions.eq("email", username);
//		c2= Restrictions.eq("password", password);
//		List <Membre> l=null;
//		l= membreMod.authentifier(c1, c2);
//		if (l.size() > 0) {
//			MembreBean m=new MembreBean();
//			membre=l.iterator().next();
//			m.setM(membre);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"bienvenu "+membre.getNom()+" "+membre.getPrenom(),null));
//			return  "membre";
//		}
//		else{
//		Criterion c3;
//		Criterion c4;
//		c3= Restrictions.eq("username", username);
//		c4= Restrictions.eq("password", password);
//		List <Administrateur> a=null;
//		a=adminMod.authentifier(c3, c4);
//		if(a.size()>0)
//		{
//		//	admin=a.iterator().next();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"bienvenu adminsistrateur",null));
//			return  "administrateur";
//		}
//		else
//			return "echec";
//		}
//	}

}
