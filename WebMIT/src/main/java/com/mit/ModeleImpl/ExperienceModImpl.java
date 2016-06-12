package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.ExperienceMod;
import com.mit.dao.ExperienceDAO;
import com.mit.entity.Experience;

@Transactional
@Service("expMod")
public class ExperienceModImpl implements ExperienceMod{

//	private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	@Autowired
	private ExperienceDAO expDao;
	//=(ExperienceDAO) context.getBean("experienceDao");
	private Experience exp=new Experience();
	
	
	public Experience getExp() {
		return exp;
	}

	public void setExp(Experience exp) {
		this.exp = exp;
	}

	@Override
	public void ajouterExp(Experience e) {
		expDao.saveOrUpdate(e);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierExp(Experience e) {
		expDao.saveOrUpdate(e);
		
	}

	@Override
	public void supprimerExp(Experience e) {
		expDao.delete(e);
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Experience> consulterExp() {
		// TODO Auto-generated method stub
		return (List<Experience>) expDao.findAll(Experience.class);
	}

	@Override
	public Experience filtrer(int id) {
		// TODO Auto-generated method stub
		return (Experience) expDao.findById(Experience.class, id);
	}

	@Override
	public Experience recherche(int id) {
		// TODO Auto-generated method stub
		return (Experience) expDao.findBy(Experience.class, id);
	}

}
