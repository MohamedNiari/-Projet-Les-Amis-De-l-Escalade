package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Topo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TopoDaoImplementation implements DaoInterface<Topo, Long> {

	private Session currentSession;

	private Transaction currentTransaction;

	/*
	 * Constructor
	 */
	public TopoDaoImplementation() {

	}

	/*
	 * Création de la session factory
	 */
	private static SessionFactory getSessionFactory() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Topo.class)
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
	public void create(Topo entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Topo entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(Topo entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topo> findAll() {
		List<Topo> Topos = (List<Topo>) getCurrentSession().createQuery("from escalade").list();
		return Topos;
	}

	@Override
	public void deleteAll() {
		List<Topo> entityList = findAll();
		for (Topo entity : entityList) {
			delete(entity);
		}
	}

	@Override
	public Topo findById(Long id) {
		Topo Topo = (Topo) getCurrentSession().get(Topo.class, id);
		return Topo;
	}
}
