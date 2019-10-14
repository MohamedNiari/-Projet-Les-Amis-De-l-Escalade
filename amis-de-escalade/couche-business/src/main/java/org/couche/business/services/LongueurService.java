package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.LongueurDaoImplementation;
import org.couche.model.entities.Longueur;

public class LongueurService {

	private static LongueurDaoImplementation longueurDao;

	public LongueurService() {
		longueurDao = new LongueurDaoImplementation();
	}

	public void create(Longueur longueur) {
		longueurDao.openCurrentSessionwithTransaction();
		longueurDao.create(longueur);
		longueurDao.closeCurrentSessionwithTransaction();
	}

	public void update(Longueur longueur) {
		longueurDao.openCurrentSessionwithTransaction();
		longueurDao.update(longueur);
		longueurDao.closeCurrentSessionwithTransaction();
	}

	public Longueur findById(Long id) {
		longueurDao.openCurrentSession();
		Longueur longueur = longueurDao.findById(id);
		longueurDao.closeCurrentSession();
		return longueur;
	}

	public void delete(Long id) {
		longueurDao.openCurrentSessionwithTransaction();
		Longueur longueur = longueurDao.findById(id);
		longueurDao.delete(longueur);
		longueurDao.closeCurrentSessionwithTransaction();
	}

	public List<Longueur> findAll() {
		longueurDao.openCurrentSession();
		List<Longueur> longueurs = longueurDao.findAll();
		longueurDao.closeCurrentSession();
		return longueurs;
	}

	public void deleteAll() {
		longueurDao.openCurrentSessionwithTransaction();
		longueurDao.deleteAll();
		longueurDao.closeCurrentSessionwithTransaction();
	}

}
