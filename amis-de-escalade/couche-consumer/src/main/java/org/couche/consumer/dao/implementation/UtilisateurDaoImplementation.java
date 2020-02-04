package org.couche.consumer.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UtilisateurDaoImplementation implements DaoInterface<Utilisateur, Long> {

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
	public void create(Utilisateur utilisateur) {
		getCurrentSession().persist(utilisateur);

	}

	@Override
	public void update(Utilisateur utilisateur) {
		getCurrentSession().update(utilisateur);
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		getCurrentSession().delete(utilisateur);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findAll() {
		List<Utilisateur> Utilisateurs = (List<Utilisateur>) getCurrentSession().createQuery("from escalade").list();
		return Utilisateurs;
	}

	@Override
	public void deleteAll() {
		List<Utilisateur> utilisateurList = findAll();
		for (Utilisateur utilisateur : utilisateurList) {
			delete(utilisateur);
		}
	}

	@Override
	public Utilisateur findById(Long id) {
		Utilisateur utilisateur = (Utilisateur) getCurrentSession().get(Utilisateur.class, id);
		return utilisateur;
	}

	public List<Utilisateur> findByEmail(String adresseMail) {
		List<Utilisateur> utilisateur = new ArrayList<Utilisateur>();
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteria = builder.createQuery(Utilisateur.class);

		Root<Utilisateur> utilisateurRoot = criteria.from(Utilisateur.class);
		Query<Utilisateur> query;

		criteria.select(utilisateurRoot).where(builder.equal(utilisateurRoot.get("adresseMail"), adresseMail));
		query = getCurrentSession().createQuery(criteria);

		utilisateur = query.getResultList();
		return utilisateur;
	}

	public Boolean checkLogin(String motDePasse, String adresseMail) {

		boolean flag = false;
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteria = builder.createQuery(Utilisateur.class);

		Root<Utilisateur> utilisateurRoot = criteria.from(Utilisateur.class);
		Query<Utilisateur> query;

		criteria.select(utilisateurRoot).where(builder.and(builder.equal(utilisateurRoot.get("motDePasse"), motDePasse),
				builder.equal(utilisateurRoot.get("adresseMail"), adresseMail)));
		query = getCurrentSession().createQuery(criteria);

		flag = query.getResultList().size() > 0;
		return flag;

	}

	public void validationEmail(String adresseMail) throws Exception {

		if (adresseMail != null) {
			if (!adresseMail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			} else if (nombreEmail(adresseMail) > 0) {
				throw new Exception("L'adresse mail existe déjà.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse Mail.");
		}
	}

	public void validation(String nom, String type) throws Exception {

		String messageErreur;

		if (type.equals("Ville")) {
			messageErreur = "La ville doit contenir au moins 3 caractères.";
		} else {
			messageErreur = "Le " + type + " doit contenir au moins 3 caractères.";
		}

		if (nom != null && nom.length() < 3) {
			throw new Exception(messageErreur);
		}
	}

	public void validationMotDePasse(String motDePasse, String confirmation) throws Exception {

		if (motDePasse != null && confirmation != null) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motDePasse.length() < 5) {
				throw new Exception("Les mots de passe doivent contenir au moins 5 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}

	}

	public Long nombreEmail(String adresseMail) {

		Long count = 0L;
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Utilisateur> utilisateurRoot = criteria.from(Utilisateur.class);

		criteria.select(builder.count(utilisateurRoot))
				.where(builder.equal(utilisateurRoot.get("adresseMail"), adresseMail));
		count = getCurrentSession().createQuery(criteria).getSingleResult();

		return count;
	}

}
