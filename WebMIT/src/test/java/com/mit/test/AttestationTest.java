package com.mit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mit.Modele.AttestationMod;
import com.mit.Modele.MembreMod;
import com.mit.Modele.ProjetMod;
import com.mit.entity.Attestation;
import com.mit.entity.AttestationId;
import com.mit.entity.Membre;
import com.mit.entity.Projet;

public class AttestationTest {
	private static ClassPathXmlApplicationContext context;
	private static AttestationMod attMod;
	private ProjetMod pr;
	private MembreMod m;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		attMod=(AttestationMod)context.getBean("attestationMod");
		pr=(ProjetMod) context.getBean("projetMod");
		m=(MembreMod) context.getBean("membreMod");
	}

	@Test
	public void testAjouterAttest() {
		Attestation a=new Attestation();
		Projet p=pr.filtrer(1);
		Membre m1=m.filtrer(7454453);
		a.setId(new AttestationId(7454453, 6, 1));
		a.setMembre(m1);
		a.setProjet(p);
		attMod.ajouterAttest(a);
	}

}
