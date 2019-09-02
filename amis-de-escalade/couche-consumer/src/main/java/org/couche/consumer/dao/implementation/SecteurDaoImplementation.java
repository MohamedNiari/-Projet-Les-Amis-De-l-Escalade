package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Secteur;
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
	@Override
	public void create(Secteur entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Secteur entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(Secteur entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Secteur> findAll() {
		List<Secteur> Secteurs = (List<Secteur>) getCurrentSession().createQuery("from escalade").list();
		return Secteurs;
	}

	@Override
	public void deleteAll() {
		List<Secteur> entityList = findAll();
		for (Secteur entity : entityList) {
			delete(entity);
		}
	}

	@Override
	public Secteur findById(Long id) {
		Secteur Secteur = (Secteur) getCurrentSession().get(Secteur.class, id);
		return Secteur;
	}
	
}
