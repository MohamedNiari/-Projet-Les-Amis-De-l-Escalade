package org.couche.consumer.dao.implementation;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Site;
import org.couche.model.entities.Topo;
import org.couche.model.entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
				.addAnnotatedClass(Utilisateur.class).buildSessionFactory();
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
	public void create(Topo topo) {
		getCurrentSession().save(topo);
	}

	@Override
	public void update(Topo topo) {
		getCurrentSession().update(topo);
	}
	
	public void merge(Topo topo) {
		getCurrentSession().merge(topo);
	}

	@Override
	public void delete(Topo topo) {
		getCurrentSession().delete(topo);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topo> findAll() {
		List<Topo> Topos = (List<Topo>) getCurrentSession().createQuery("SELECT t FROM Topo t").list();
		return Topos;
	}

	@Override
	public void deleteAll() {
		List<Topo> topoList = findAll();
		for (Topo topo : topoList) {
			delete(topo);
		}
	}

	@Override
	public Topo findById(Long id) {
		Topo Topo = (Topo) getCurrentSession().get(Topo.class, id);
		return Topo;
	}
	
	public List<Topo> findByUser(Utilisateur utilisateur) {

		// Création du CriteriaBuilder pour la construction des requetes
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Topo> criteria = builder.createQuery(Topo.class);

		// Création du root pour l'entité Commentaire
		Root<Topo> topoRoot = criteria.from(Topo.class);
		criteria.where(builder.equal(topoRoot.get("utilisateur"), utilisateur));

		Query<Topo> query;
		query = getCurrentSession().createQuery(criteria);

		List<Topo> topos = query.getResultList();
		return topos;

	}
	
	public List<Topo> disponible() {

		// Création du CriteriaBuilder pour la construction des requetes
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Topo> criteria = builder.createQuery(Topo.class);

		// Création du root pour l'entité Commentaire
		Root<Topo> topoRoot = criteria.from(Topo.class);
		criteria.where(builder.equal(topoRoot.get("disponible"), true));

		Query<Topo> query;
		query = getCurrentSession().createQuery(criteria);

		List<Topo> topos = query.getResultList();
		return topos;

	}

	public void persist(Topo topo) {
		getCurrentSession().persist(topo);
		
	}

}
