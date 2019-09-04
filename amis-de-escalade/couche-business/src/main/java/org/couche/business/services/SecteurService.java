package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.SecteurDaoImplementation;
import org.couche.consumer.dao.implementation.UtilisateurDaoImplementation;
import org.couche.model.entities.Secteur;

public class SecteurService {

	private static SecteurDaoImplementation secteurDao;
	
	public SecteurService() {
		secteurDao = new SecteurDaoImplementation();
	}

	public void create(Secteur entity) {
		secteurDao.openCurrentSessionwithTransaction();
		secteurDao.create(entity);
		secteurDao.closeCurrentSessionwithTransaction();
	}

	public void update(Secteur entity) {
		secteurDao.openCurrentSessionwithTransaction();
		secteurDao.update(entity);
		secteurDao.closeCurrentSessionwithTransaction();
	}

	public Secteur findById(Long id) {
		secteurDao.openCurrentSession();
		Secteur secteur = secteurDao.findById(id);
		secteurDao.closeCurrentSession();
		return secteur;
	}

	public void delete(Long id) {
		secteurDao.openCurrentSessionwithTransaction();
		Secteur secteur = secteurDao.findById(id);
		secteurDao.delete(secteur);
		secteurDao.closeCurrentSessionwithTransaction();
	}

	public List<Secteur> findAll() {
		secteurDao.openCurrentSession();
		List<Secteur> secteurs = secteurDao.findAll();
		secteurDao.closeCurrentSession();
		return secteurs;
	}

	public void deleteAll() {
		secteurDao.openCurrentSessionwithTransaction();
		secteurDao.deleteAll();
		secteurDao.closeCurrentSessionwithTransaction();
	}

}
