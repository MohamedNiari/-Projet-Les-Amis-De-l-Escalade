package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.CommentaireDaoImplementation;
import org.couche.model.entities.Commentaire;

public class CommentaireService {

	private static CommentaireDaoImplementation commentaireDao;

	public void create(Commentaire entity) {
		commentaireDao.openCurrentSessionwithTransaction();
		commentaireDao.create(entity);
		commentaireDao.closeCurrentSessionwithTransaction();
	}

	public void update(Commentaire entity) {
		commentaireDao.openCurrentSessionwithTransaction();
		commentaireDao.update(entity);
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
