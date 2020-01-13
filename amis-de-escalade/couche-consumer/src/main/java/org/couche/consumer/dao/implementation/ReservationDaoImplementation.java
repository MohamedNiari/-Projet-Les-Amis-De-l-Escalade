package org.couche.consumer.dao.implementation;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Reservation;
import org.couche.model.entities.Site;
import org.couche.model.entities.Topo;
import org.couche.model.entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ReservationDaoImplementation implements DaoInterface<Reservation, Long> {

	private Session currentSession;

	private Transaction currentTransaction;

	/*
	 * Constructor
	 */
	public ReservationDaoImplementation() {

	}

	/*
	 * Création de la session factory
	 */
	private static SessionFactory getSessionFactory() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Reservation.class)
				.addAnnotatedClass(Site.class).addAnnotatedClass(Utilisateur.class).buildSessionFactory();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findAll() {
		List<Reservation> reservations = (List<Reservation>) getCurrentSession().createQuery("from Reservation").list();
		return reservations;
	}

	@Override
	public void deleteAll() {
		List<Reservation> reservationList = findAll();
		for (Reservation reservation : reservationList) {
			delete(reservation);
		}
	}

	public List<Reservation> findByUtilisateur(Long utilisateurId) {
		List<Reservation> reservations = (List<Reservation>) getCurrentSession().get(Utilisateur.class, utilisateurId)
				.getReservationsUtilisateur();
		return reservations;
	}

	@Override
	public void create(Reservation reservation) {
		getCurrentSession().save(reservation);

	}

	@Override
	public void update(Reservation reservation) {
		getCurrentSession().update(reservation);

	}

	@Override
	public Reservation findById(Long id) {
		Reservation reservation = (Reservation) getCurrentSession().get(Reservation.class, id);
		return reservation;
	}

	@Override
	public void delete(Reservation reservation) {
		getCurrentSession().delete(reservation);

	}

	public Boolean isTopoEnAttente(Topo topo, Utilisateur utilisateur) {

		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Reservation> criteria = builder.createQuery(Reservation.class);
		Root<Reservation> reservationRoot = criteria.from(Reservation.class);
		
		Predicate predicateAccepter = builder.equal(reservationRoot.get("accepter"), false);
		Predicate predicateTopo = builder.equal(reservationRoot.get("topo"), topo);
		Predicate predicateUtilisateur = builder.equal(reservationRoot.get("utilisateur"), utilisateur);

		Predicate finalPredicate = builder.and(predicateAccepter, predicateTopo, predicateUtilisateur);
		criteria.where(finalPredicate);
		
		Query<Reservation> query;
		query = getCurrentSession().createQuery(criteria);

		System.out.println("size query : " + query.getResultList().size());
		return query.getResultList().size() >= 1;
	}

}
