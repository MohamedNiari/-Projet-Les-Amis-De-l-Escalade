package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Site;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SiteDaoImplementation implements DaoInterface<Site, Long> {

	private Session currentSession;

	private Transaction currentTransaction;

	/*
	 * Constructor
	 */
	public SiteDaoImplementation() {

	}

	/*
	 * Création de la session factory
	 */
	private static SessionFactory getSessionFactory() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Site.class)
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
	public void create(Site site) {
		getCurrentSession().save(site);

	}

<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public void update(Site site) {
		getCurrentSession().update(site);
	}

<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public void delete(Site site) {
		getCurrentSession().delete(site);

	}

	@SuppressWarnings("unchecked")
<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public List<Site> findAll() {
		List<Site> sites = (List<Site>) getCurrentSession().createQuery("SELECT t FROM Site t").list();
		return sites;
	}

<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public void deleteAll() {
		List<Site> siteList = findAll();
		for (Site site : siteList) {
			delete(site);
		}
	}

<<<<<<< HEAD
	
=======
	@Override
>>>>>>> 6c588421674f436a525669a9ad2643eeac833cf7
	public Site findById(Long id) {
		Site site = (Site) getCurrentSession().get(Site.class, id);
		return site;
	}

}
