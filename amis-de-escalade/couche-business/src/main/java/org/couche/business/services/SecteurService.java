package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.SecteurDaoImplementation;
import org.couche.consumer.dao.implementation.UtilisateurDaoImplementation;
import org.couche.model.entities.Secteur;
import org.couche.model.entities.Site;

public class SecteurService {

	private static SecteurDaoImplementation secteurDao;
	
	public SecteurService() {
		secteurDao = new SecteurDaoImplementation();
	}

	public void create(Secteur secteur) {
		secteurDao.openCurrentSessionwithTransaction();
		secteurDao.create(secteur);
		secteurDao.closeCurrentSessionwithTransaction();
	}

	public void update(Secteur secteur) {
		secteurDao.openCurrentSessionwithTransaction();
		secteurDao.update(secteur);
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
	
	public List<Secteur> findBySite(Long siteid){
		secteurDao.openCurrentSession();
		List<Secteur> secteurs = secteurDao.findBySite(siteid);
		secteurDao.closeCurrentSession();
		return secteurs;		
	}

}
