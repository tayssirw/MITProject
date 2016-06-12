package com.mit.controler;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
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

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.mit.Modele.ContratSocMod;
import com.mit.Modele.ProjetMod;
import com.mit.Modele.SocieteMod;
import com.mit.entity.Contratmembre;
import com.mit.entity.Contratsociete;
import com.mit.entity.ContratsocieteId;
import com.mit.entity.Projet;
import com.mit.entity.Societe;
import com.mit.entity.Tache;
import com.mit.entity.TacheId;

@Component("contratSocieteBean")
@Scope("session")
@SessionScoped
public class ContratSocieteBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private ClassPathXmlApplicationContext context;
	private Contratsociete conS;
	private ContratSocMod conMod;
	private List<Contratsociete> Contrats;
	private Projet projet;
	private Societe societe;
	private SocieteMod s;
	private ProjetMod p;
	private ContratsocieteId id ; 
	
	
	public Contratsociete getConS() {
		return conS;
	}



	public void setConS(Contratsociete conS) {
		this.conS = conS;
	}



	public List<Contratsociete> getContrats() {
		Contrats=conMod.consulterContrat();
		return Contrats;
	}



	public void setContrats(List<Contratsociete> contrats) {
		Contrats = contrats;
	}



	@PostConstruct
	public void init()
	{
		context=new ClassPathXmlApplicationContext("application-context.xml");
		conMod=(ContratSocMod) context.getBean("contratSocMod");
		id=new ContratsocieteId();
		conS=new Contratsociete(id,societe,projet);
		Contrats=new ArrayList<Contratsociete>();
		p=(ProjetMod) context.getBean("projetMod");
		s=(SocieteMod) context.getBean("societeMod");
		
	}
	
	public void ajouterContratSociet()
	{
		
		try{
		
			societe=s.filtrer(conS.getId().getIdSociete());
			projet=p.filtrer(conS.getId().getIdProjet());
			conMod.ajouterContrat(conS);
			id=new ContratsocieteId();
			conS=new Contratsociete(id,societe,projet);
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Contrat créer",null));
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur "+e.getMessage()+e.toString()+e.getLocalizedMessage(),null));
		}
	}
	
	public void supprimerContrat(Contratsociete cs)
	{
		conMod.supprimerContrat(cs);
	}
	
	public void imprimerContrat(Contratsociete cs)
	{
try{
			
			projet= p.recherche(cs.getId().getIdProjet());
			societe=s.recherche(cs.getId().getIdSociete());
			
			PdfReader r=new PdfReader("C:\\Users\\Dell\\Desktop\\papier_en_tete.pdf");
			long name=new Date().getTime();
			PdfStamper doc= new PdfStamper(r, new FileOutputStream("C:\\Users\\Dell\\Desktop\\"+name+".pdf"));
			
	    //    for(int i=1; i<= r.getNumberOfPages(); i++){

                PdfContentByte content = doc.getOverContent(1);
                Font f = new Font(FontFamily.HELVETICA, 15);
                Phrase pa = new Phrase("Contrat ",new Font(FontFamily.TIMES_ROMAN, 32));
                ColumnText.showTextAligned(content, Element.ALIGN_CENTER, pa, 297, 600, 0);
                
//                Phrase p = new Phrase("Sociéte : "+societe.getNomSociete(),f);
//                ColumnText.showTextAligned(content, Element.ALIGN_CENTER, p, 297, 550, 0);
//                
               
//        		ColumnText.showTextAligned(content, Element.ALIGN_CENTER, new Phrase("Projet : "+projet.getTitreProjet(),f), 297, 525, 0);
        		
        		 Phrase phr=new Phrase("date de Contrat "+cs.getDateContrat(),f);
                 ColumnText.showTextAligned(content, Element.ALIGN_CENTER, phr, 297, 500, 0);
                
                 ColumnText.showTextAligned(content, Element.ALIGN_CENTER, new Phrase(cs.getDebutContrat()+" au "+cs.getFinContrat(),f)
         		, 297, 475, 0);
                 ColumnText.showTextAligned(content, Element.ALIGN_CENTER, new Phrase("avec "+cs.getCoutPayer()+"DT",f), 297, 450, 0);
               
                 
                 Phrase s = new Phrase("Signature ",new Font(FontFamily.TIMES_ROMAN, 20));
                 ColumnText.showTextAligned(content, Element.ALIGN_RIGHT, s, 500, 300, 0);
                 
                 Phrase c = new Phrase("Cache societe ",new Font(FontFamily.TIMES_ROMAN, 20));
                 ColumnText.showTextAligned(content, Element.ALIGN_RIGHT, c, 200, 300, 0);
               
                
	      //  }  
              
			doc.close();
			r.close();
			
			Desktop.getDesktop().open(new File("C:\\Users\\Dell\\Desktop\\"+name+".pdf"));
			
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur "+e.getMessage() +e.toString(),null));
		}
		
	}

}
