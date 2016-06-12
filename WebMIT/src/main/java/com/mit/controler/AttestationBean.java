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
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.mit.Modele.AttestationMod;
import com.mit.Modele.ContratMembreMod;
import com.mit.Modele.MembreMod;
import com.mit.Modele.ProjetMod;
import com.mit.Modele.TacheMod;
import com.mit.entity.Attestation;
import com.mit.entity.AttestationId;
import com.mit.entity.Contrat;
import com.mit.entity.Contratmembre;
import com.mit.entity.Membre;
import com.mit.entity.Projet;
import com.mit.entity.Tache;
import com.mit.entity.TacheId;


@Component("attestationBean")
@SessionScoped
@Scope("session")
public class AttestationBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static ClassPathXmlApplicationContext context;
	private AttestationMod attestationMod;
	private Attestation attestation;
	private List<Attestation> attestations;
	private Membre membre;
	private Projet projet;
	
	
	private ContratMembreMod conMemMod;
	private ProjetMod projetMod;
	private MembreMod membreMod;
	private TacheMod tacheMod;
	private List<Contratmembre>contrats;
	private AttestationId id;
	
	@PostConstruct
	public void init()
	{
		context =new ClassPathXmlApplicationContext("application-context.xml");
		attestationMod=(AttestationMod) context.getBean("attestationMod");
		id=new AttestationId();
		membre=new Membre();
		projet=new Projet();
		attestation = new Attestation(id,membre,projet);
		attestations=new ArrayList<Attestation>();
		projetMod=(ProjetMod) context.getBean("projetMod");
		membreMod=(MembreMod) context.getBean("membreMod");
		tacheMod=(TacheMod) context.getBean("tacheMod");
		conMemMod=(ContratMembreMod) context.getBean("contratMemMod");
		contrats=new ArrayList<Contratmembre>();
//		taches=new ArrayList<Tache>();
	}

	public Attestation getAttestation() {
		return attestation;
	}

	public void setAttestation(Attestation attestation) {
		this.attestation = attestation;
	}
	
	public List<Attestation> getAttestations() {
		attestations=attestationMod.consulterAttest();
		return attestations;
	}

	
	public List<Contratmembre> getContrats() {
		contrats=conMemMod.consulterContrat();
		return contrats;
	}

	public void setContrats(List<Contratmembre> contrats) {
		this.contrats = contrats;
	}

	public void setAttestations(List<Attestation> attestations) {
		this.attestations = attestations;
	}
	
	


	public void ajouterAttest()
	{
		try{
			membre=membreMod.filtrer(attestation.getId().getCin());
			projet=projetMod.filtrer(attestation.getId().getIdProjet());
			
			attestationMod.ajouterAttest(attestation);
			id=new AttestationId();
			attestation=new Attestation(id,membre,projet);
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Attestation Enregistrer", null));
		}catch(Exception e )
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "erreur "+e.getMessage(), null));
		}
	}
	
	
	public void imprimer(Attestation attestation)
	{
		
		try{
			
			projet=projetMod.recherche(attestation.getId().getIdProjet());
			membre=membreMod.recherche(attestation.getId().getCin());
			
			PdfReader r=new PdfReader("C:\\Users\\Dell\\Desktop\\papier_en_tete.pdf");
			long name=new Date().getTime();
			PdfStamper doc= new PdfStamper(r, new FileOutputStream("C:\\Users\\Dell\\Desktop\\"+name+".pdf"));
			
	    //    for(int i=1; i<= r.getNumberOfPages(); i++){

                PdfContentByte content = doc.getOverContent(1);
                Font f = new Font(FontFamily.HELVETICA, 15);
                Phrase pa = new Phrase("Attestation ",new Font(FontFamily.TIMES_ROMAN, 32));
                ColumnText.showTextAligned(content, Element.ALIGN_CENTER, pa, 297, 600, 0);
                
                Phrase p = new Phrase("Le directeur générale de « MIT », ",f);
                ColumnText.showTextAligned(content, Element.ALIGN_CENTER, p, 297, 550, 0);
                
                ColumnText.showTextAligned(content, Element.ALIGN_CENTER,  new Phrase(" atteste que  « "+membre.getNom()+" "+membre.getPrenom()+" » a effectué les tâches de : ",f), 297, 525, 0);

                String tache="";
        		for(Contratmembre c:this.getContrats())
        		{
        		
	        			if(attestation.getId().getIdProjet()==c.getId().getIdProjet() && attestation.getId().getCin()==c.getId().getCin() )
	        			{
	        				TacheId id=new TacheId(c.getId().getIdProjet(),c.getId().getIdTache());
	        				Tache t=tacheMod.recherche(id);
	        				//tachs.add(t);
	        				tache=tache+"« "+t.getNomTache()+" » ";
	        			}
        			
        		}
        		ColumnText.showTextAligned(content, Element.ALIGN_CENTER, new Phrase(tache,f), 297, 500, 0);
        		
        		 Phrase phr=new Phrase("Du projet « "+projet.getTitreProjet()+" » ",f);
                 ColumnText.showTextAligned(content, Element.ALIGN_CENTER, phr, 297, 475, 0);
                
                 ColumnText.showTextAligned(content, Element.ALIGN_CENTER, new Phrase("Dans notre établissement du "+attestation.getDateDebut()+" jusqu'a "+attestation.getDateFin(),f), 297, 450, 0);

                
                 ColumnText.showTextAligned(content, Element.ALIGN_CENTER, new Phrase("Nous délivrons la présente attestation pour servir et valoir ce que de droit",f), 297, 425, 0);
               
                 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                 String dat = dateFormat.format(new Date());
                 ColumnText.showTextAligned(content, Element.ALIGN_CENTER, new Phrase("Fait à Ghazéla le "+dat,f), 400, 400, 0);

                 Phrase s = new Phrase("Signature ",new Font(FontFamily.TIMES_ROMAN, 20));
                 ColumnText.showTextAligned(content, Element.ALIGN_RIGHT, s, 500, 300, 0);
               
                
	      //  }  
              
			doc.close();
			r.close();
			
			Desktop.getDesktop().open(new File("C:\\Users\\Dell\\Desktop\\"+name+".pdf"));
			
		}catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"erreur"+e.getMessage() +e.toString()+e.getLocalizedMessage(),null));
		}
		
	}


}
