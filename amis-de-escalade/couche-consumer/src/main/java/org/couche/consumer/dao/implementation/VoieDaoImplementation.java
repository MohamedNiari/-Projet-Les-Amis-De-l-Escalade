package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Secteur;
import org.couche.model.entities.Site;
import org.couche.model.entities.Voie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VoieDaoImplementation implements DaoInterface<Voie, Long> {

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
				.addAnnotatedClass(Secteur.class).buildSessionFactory();
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
	public void create(Voie voie) {
		getCurrentSession().save(voie);

	}

	@Override
	public void update(Voie voie) {
		getCurrentSession().update(voie);
	}

	@Override
	public void delete(Voie voie) {
		getCurrentSession().delete(voie);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voie> findAll() {
		List<Voie> Voies = (List<Voie>) getCurrentSession().createQuery("from escalade").list();
		return Voies;
	}

	@Override
	public void deleteAll() {
		List<Voie> voieList = findAll();
		for (Voie voie : voieList) {
			delete(voie);
		}
	}

	@Override
	public Voie findById(Long id) {
		Voie Voie = (Voie) getCurrentSession().get(Voie.class, id);
		return Voie;
	}

	public List<Voie> findBySecteur(Long secteurid) {
		List<Voie> voies = (List<Voie>) getCurrentSession().get(Secteur.class, secteurid).getVoies();
		return voies;
	}

}
