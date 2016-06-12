package com.mit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mit.Modele.ContratMembreMod;
import com.mit.Modele.MembreMod;
import com.mit.Modele.TacheMod;
import com.mit.entity.Contratmembre;
import com.mit.entity.ContratmembreId;
import com.mit.entity.TacheId;

public class ContratMembreTest {
	
	private static ClassPathXmlApplicationContext context;
	private static ContratMembreMod cm ;
	private Contratmembre c;
	private TacheMod t;
	private MembreMod m;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		cm=(ContratMembreMod) context.getBean("contratMemMod");
		c=new Contratmembre();
		
		t=(TacheMod) context.getBean("tacheMod");
		m=(MembreMod) context.getBean("membreMod");
	}

	@Test
	public void testAjouterContrat() {
		ContratmembreId id=new ContratmembreId();
		id.setCin(7454453);
		id.setIdProjet(6);
		id.setIdTache(1);
		id.setIdContrat(1);
		c.setId(id);
		c.setMembre(m.filtrer(7454453));
		c.setTache(t.filtrer(new TacheId(6,1)));
		cm.ajouterContrat(c);
	}

}
