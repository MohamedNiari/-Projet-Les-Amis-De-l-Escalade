package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.UtilisateurDaoImplementation;
import org.couche.model.entities.Utilisateur;

public class UtilisateurService {

	private UtilisateurDaoImplementation utilisateurDao;

	public UtilisateurService() {
		utilisateurDao = new UtilisateurDaoImplementation();
	}

	public void create(Utilisateur utilisateur) {
		utilisateurDao.openCurrentSessionwithTransaction();
		utilisateurDao.create(utilisateur);
		utilisateurDao.closeCurrentSessionwithTransaction();
	}

	public void update(Utilisateur utilisateur) {
		utilisateurDao.openCurrentSessionwithTransaction();
		utilisateurDao.update(utilisateur);
		utilisateurDao.closeCurrentSessionwithTransaction();
	}

	public Utilisateur findById(Long id) {
		utilisateurDao.openCurrentSession();
		Utilisateur utilisateur = utilisateurDao.findById(id);
		utilisateurDao.closeCurrentSession();
		return utilisateur;
	}

	public void delete(Long id) {
		utilisateurDao.openCurrentSessionwithTransaction();
		Utilisateur utilisateur = utilisateurDao.findById(id);
		utilisateurDao.delete(utilisateur);
		utilisateurDao.closeCurrentSessionwithTransaction();
	}

	public List<Utilisateur> findAll() {
		utilisateurDao.openCurrentSession();
		List<Utilisateur> utilisateurs = utilisateurDao.findAll();
		utilisateurDao.closeCurrentSession();
		return utilisateurs;
	}

	public void deleteAll() {
		utilisateurDao.openCurrentSessionwithTransaction();
		utilisateurDao.deleteAll();
		utilisateurDao.closeCurrentSessionwithTransaction();
	}
	
	public Boolean checkLogin(String nom, String motDePasse) {
		utilisateurDao.openCurrentSessionwithTransaction();
		Boolean flag = utilisateurDao.checkLogin(nom, motDePasse);
		utilisateurDao.closeCurrentSessionwithTransaction();
		return flag;
	}

}
