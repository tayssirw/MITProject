package com.mit.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mit.Modele.CvMod;
import com.mit.Modele.MembreMod;
import com.mit.entity.Cv;
import com.mit.entity.Diplome;
import com.mit.entity.Experience;
import com.mit.entity.Membre;

public class CvTest {
	
	private static ClassPathXmlApplicationContext context;
	private static CvMod cvMod;
	private MembreMod m;
	
	private Cv cv;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		cvMod=(CvMod)context.getBean("cvMod");
		m=(MembreMod)context.getBean("membreMod");
		cv=new Cv();
	}


	@Test
	public void testAjouterCv() {
		Membre b=new Membre();
		b.setCin(1234560);
		b.setNom("sliti");
		b.setPrenom("bayan");
		b.setAdr("ariana");
		b.setTel(23158761);
		cv.getMembres().add(b);
//		Experience e=new Experience();
//		e.setDateDeb(new Date());
//		e.setDateFin(new Date());
//		e.setDetail("stage");
		
	//	cv.getExperiences().add(e);
		cv.getDiplomes().add(new Diplome());
		cvMod.ajouterCv(cv);
		for(Membre m1 :cv.getMembres())
		{
			m1.setCv(cv);
			m.ajouterMembre(m1);
		}
		
	}

}
