package com.mit.ModeleImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mit.Modele.PvMod;
import com.mit.dao.PvreunionDAO;
import com.mit.entity.Pvreunion;

@Transactional
@Service("pvMod")
public class PvModImpl implements PvMod{
	
//	private static ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context");
	@Autowired
	private PvreunionDAO pvDao;
	//=(PvreunionDAO) context.getBean("pvreunionDao");
	private Pvreunion pv=new Pvreunion();
	

	public Pvreunion getPv() {
		return pv;
	}

	public void setPv(Pvreunion pv) {
		this.pv = pv;
	}

	@Override
	public void ajouterPv(Pvreunion p) {
		// TODO Auto-generated method stub
		pvDao.saveOrUpdate(p);
		
	}

	@Override
	public void modifierPv(Pvreunion p) {
		// TODO Auto-generated method stub
		pvDao.saveOrUpdate(p);
		
	}

	@Override
	public void supprimerPv(Pvreunion p) {
		// TODO Auto-generated method stub
		pvDao.delete(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pvreunion> consulterPv() {
		// TODO Auto-generated method stub
		return (List<Pvreunion>) pvDao.findAll(Pvreunion.class);
	}

	@Override
	public Pvreunion filtrer(int id) {
		// TODO Auto-generated method stub
		return (Pvreunion) pvDao.findById(Pvreunion.class, id);
	}

	@Override
	public Pvreunion recherche(int id) {
		// TODO Auto-generated method stub
		return (Pvreunion) pvDao.findBy(Pvreunion.class, id);
	}
	

}
