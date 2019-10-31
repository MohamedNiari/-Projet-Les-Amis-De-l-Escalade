package org.couche.consumer.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Secteur;
import org.couche.model.entities.Site;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SecteurDaoImplementation implements DaoInterface<Secteur, Long> {

	private Session currentSession;

	private Transaction currentTransaction;

	public SecteurDaoImplementation() {

	}

	/*
	 * Création de la session factory
	 */
	private static SessionFactory getSessionFactory() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Secteur.class)
				.buildSessionFactory();
		return factory;
	}

	/*
	 * Création de la session
	 */
	public Session openCurrentSession() {
		// création de la session
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	/*
	 * Création de la session avec transaction
	 */
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	/*
	 * Cloture de la session
	 */
	public void closeCurrentSession() {
		currentSession.close();
	}

	/*
	 * Cloture de la session avec transaction
	 */
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	/*
	 * Getters and setters
	 */
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	/*
	 * Methodes d'accès la base de données
	 */
<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public void create(Secteur secteur) {
		getCurrentSession().save(secteur);

	}

<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public void update(Secteur secteur) {
		getCurrentSession().update(secteur);
	}

<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public void delete(Secteur secteur) {
		getCurrentSession().delete(secteur);

	}

	@SuppressWarnings("unchecked")
<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public List<Secteur> findAll() {
		List<Secteur> Secteurs = (List<Secteur>) getCurrentSession().createQuery("from escalade").list();
		return Secteurs;
	}

<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public void deleteAll() {
		List<Secteur> secteurList = findAll();
		for (Secteur secteur : secteurList) {
			delete(secteur);
		}
	}

<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public Secteur findById(Long id) {
		Secteur Secteur = (Secteur) getCurrentSession().get(Secteur.class, id);
		return Secteur;
	}
	
	
	public List<Secteur> findBySite(Long siteid) {
		List<Secteur> Secteurs = (List<Secteur>) getCurrentSession().get(Site.class, siteid).getSecteurs();
		return Secteurs;

	}

}
