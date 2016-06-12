package com.mit.ModeleImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.CvMod;
import com.mit.dao.CvDAO;
import com.mit.entity.Cv;

@Transactional
@Service("cvMod")
public class CvModImpl implements CvMod{
//	private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	@Autowired
	private CvDAO cvDao;
	//=(CvDAO) context.getBean("cvDao");
	private Cv cv;

	
	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	@Override
	public void ajouterCv(Cv c) {
		cvDao.saveOrUpdate(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierCv(Cv c) {
		cvDao.saveOrUpdate(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCv(Cv c) {
		cvDao.delete(c);
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cv> consulterCv() {
		// TODO Auto-generated method stub
		return (List<Cv>) cvDao.findAll(Cv.class);
	}

	@Override
	public Cv filtrer(int id) {
		// TODO Auto-generated method stub
		return (Cv) cvDao.findById(Cv.class, id);
	}

	@Override
	public Cv recherche(int id) {
		// TODO Auto-generated method stub
		return (Cv) cvDao.findBy(Cv.class, id);
	}

}
