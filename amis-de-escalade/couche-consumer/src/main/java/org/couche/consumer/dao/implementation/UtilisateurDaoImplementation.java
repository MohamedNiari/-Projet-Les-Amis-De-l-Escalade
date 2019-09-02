package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UtilisateurDaoImplementation implements  DaoInterface<Utilisateur, Long> {

	private Session currentSession;

	private Transaction currentTransaction;

	/*
	 * Constructor
	 */
	public UtilisateurDaoImplementation() {

	}

	/*
	 * Création de la session factory
	 */
	private static SessionFactory getSessionFactory() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Utilisateur.class)
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
	public void create(Utilisateur entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Utilisateur entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(Utilisateur entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findAll() {
		List<Utilisateur> Utilisateurs = (List<Utilisateur>) getCurrentSession().createQuery("from escalade").list();
		return Utilisateurs;
	}

	@Override
	public void deleteAll() {
		List<Utilisateur> entityList = findAll();
		for (Utilisateur entity : entityList) {
			delete(entity);
		}
	}

	@Override
	public Utilisateur findById(Long id) {
		Utilisateur Utilisateur = (Utilisateur) getCurrentSession().get(Utilisateur.class, id);
		return Utilisateur;
	}

}
