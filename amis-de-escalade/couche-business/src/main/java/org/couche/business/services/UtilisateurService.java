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
	
	public Utilisateur findByEmail(String adresseMail) {
		utilisateurDao.openCurrentSession();
		List<Utilisateur> listUtilisateur = utilisateurDao.findByEmail(adresseMail);
		utilisateurDao.closeCurrentSession();
		return listUtilisateur.get(0);
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
	
	public void validationEmail(String email) throws Exception {
		utilisateurDao.openCurrentSessionwithTransaction();
		utilisateurDao.validationEmail(email);
		utilisateurDao.closeCurrentSessionwithTransaction();
	}
	
	public void validation(String nom, String type) throws Exception {
		utilisateurDao.openCurrentSessionwithTransaction();
		utilisateurDao.validation(nom, type);
		utilisateurDao.closeCurrentSessionwithTransaction();
	}
	
	public void validationMotDePasse(String motDePasse, String confirmation) throws Exception {
		utilisateurDao.openCurrentSessionwithTransaction();
		utilisateurDao.validationMotDePasse(motDePasse, confirmation);
		utilisateurDao.closeCurrentSessionwithTransaction();
	}
	
}
