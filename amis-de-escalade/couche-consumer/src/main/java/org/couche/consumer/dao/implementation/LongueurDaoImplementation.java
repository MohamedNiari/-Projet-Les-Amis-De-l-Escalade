package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Longueur;
import org.couche.model.entities.Voie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LongueurDaoImplementation implements DaoInterface<Longueur, Long> {

	private Session currentSession;

	private Transaction currentTransaction;

	/*
	 * Constructor
	 */
	public LongueurDaoImplementation() {

	}

	/*
	 * Création de la session factory
	 */
	private static SessionFactory getSessionFactory() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Longueur.class)
				.addAnnotatedClass(Voie.class).buildSessionFactory();
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
	
	public void create(Longueur longueur) {
		getCurrentSession().save(longueur);

	}

	
	public void update(Longueur longueur) {
		getCurrentSession().update(longueur);
	}

	
	public void delete(Longueur longueur) {
		getCurrentSession().delete(longueur);

	}

	@SuppressWarnings("unchecked")
	
	public List<Longueur> findAll() {
		List<Longueur> longueurs = (List<Longueur>) getCurrentSession().createQuery("from Longueur").list();
		return longueurs;
	}

	
	public void deleteAll() {
		List<Longueur> longueurList = findAll();
		for (Longueur longueur : longueurList) {
			delete(longueur);
		}
	}

	
	public Longueur findById(Long id) {
		Longueur longueur = (Longueur) getCurrentSession().get(Longueur.class, id);
		return longueur;
	}

}
