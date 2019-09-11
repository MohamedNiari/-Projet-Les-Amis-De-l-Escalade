package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.CommentaireDaoImplementation;
import org.couche.model.entities.Commentaire;
import org.couche.model.entities.Site;
import org.couche.model.entities.Utilisateur;

public class CommentaireService {

	private static CommentaireDaoImplementation commentaireDao;
	
	public CommentaireService() {
		commentaireDao = new CommentaireDaoImplementation();
	}

	public void create(Commentaire commentaire, Utilisateur utilisateur, Site site) {
		commentaireDao.openCurrentSessionwithTransaction();
		commentaireDao.add(commentaire, utilisateur);
		commentaireDao.add(commentaire, site);
		commentaireDao.create(commentaire);
		commentaireDao.closeCurrentSessionwithTransaction();
	}

	public void update(Commentaire commentaire) {
		commentaireDao.openCurrentSessionwithTransaction();
		commentaireDao.update(commentaire);
		commentaireDao.closeCurrentSessionwithTransaction();
	}

	public Commentaire findById(Long id) {
		commentaireDao.openCurrentSession();
		Commentaire commentaire = commentaireDao.findById(id);
		commentaireDao.closeCurrentSession();
		return commentaire;
	}

	public void delete(Long id) {
		commentaireDao.openCurrentSessionwithTransaction();
		Commentaire commentaire = commentaireDao.findById(id);
		commentaireDao.delete(commentaire);
		commentaireDao.closeCurrentSessionwithTransaction();
	}

	public List<Commentaire> findAll() {
		commentaireDao.openCurrentSession();
		List<Commentaire> commentaires = commentaireDao.findAll();
		commentaireDao.closeCurrentSession();
		return commentaires;
	}

	public void deleteAll() {
		commentaireDao.openCurrentSessionwithTransaction();
		commentaireDao.deleteAll();
		commentaireDao.closeCurrentSessionwithTransaction();
	}

}
