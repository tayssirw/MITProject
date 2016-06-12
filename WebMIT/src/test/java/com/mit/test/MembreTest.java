package com.mit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mit.Modele.MembreMod;
import com.mit.entity.Membre;

public class MembreTest {
	
	
	private static ClassPathXmlApplicationContext context;
	private static MembreMod membreMod;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		membreMod=(MembreMod)context.getBean("membreMod");
	}



	@Test
	public void testAjouterMembre() {
		membreMod.ajouterMembre(new Membre(07432052));
	}

}
