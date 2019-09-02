package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Voie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VoieDaoImplementation implements  DaoInterface<Voie, Long> {

	private Session currentSession;

	private Transaction currentTransaction;

	/*
	 * Constructor
	 */
	public VoieDaoImplementation() {

	}

	/*
	 * Création de la session factory
	 */
	private static SessionFactory getSessionFactory() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Voie.class)
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
	public void create(Voie entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Voie entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(Voie entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voie> findAll() {
		List<Voie> Voies = (List<Voie>) getCurrentSession().createQuery("from escalade").list();
		return Voies;
	}

	@Override
	public void deleteAll() {
		List<Voie> entityList = findAll();
		for (Voie entity : entityList) {
			delete(entity);
		}
	}

	@Override
	public Voie findById(Long id) {
		Voie Voie = (Voie) getCurrentSession().get(Voie.class, id);
		return Voie;
	}
}
