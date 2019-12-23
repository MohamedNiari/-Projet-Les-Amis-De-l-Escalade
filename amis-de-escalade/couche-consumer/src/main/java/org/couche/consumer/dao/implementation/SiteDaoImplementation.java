package org.couche.consumer.dao.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Site;
import org.couche.model.entities.TypeRocher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sun.istack.Nullable;

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
	@Override
	public void create(Site site) {
		getCurrentSession().save(site);

	}

	@Override
	public void update(Site site) {
		getCurrentSession().update(site);
	}

	@Override
	public void delete(Site site) {
		getCurrentSession().delete(site);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Site> findAll() {
		List<Site> sites = (List<Site>) getCurrentSession().createQuery("SELECT t FROM Site t").list();
		return sites;
	}

	@Override
	public void deleteAll() {
		List<Site> siteList = findAll();
		for (Site site : siteList) {
			delete(site);
		}
	}

	@Override
	public Site findById(Long id) {
		Site site = (Site) getCurrentSession().get(Site.class, id);
		return site;
	}

	public List<Site> searchSite(String lieu, TypeRocher typeRoche, Integer numberSecteur) {		

		// Création du CriteriaBuilder pour la construction des requetes
		CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Site> criteria = builder.createQuery(Site.class);

		// Création du root pour l'entité Site et des paramètres
		Root<Site> siteRoot = criteria.from(Site.class);
		ParameterExpression<Integer> sizeSecteurParameter = builder.parameter(Integer.class);
		ParameterExpression<TypeRocher> typeRocheParameter = builder.parameter(TypeRocher.class);

		// Creation des predicats
		Predicate predicateLieu = builder.like(siteRoot.get("lieu"), "%" + lieu + "%");

		Predicate predicateRoche = null;
		if (Optional.ofNullable(typeRoche).isPresent()) {
			predicateRoche = builder.equal(siteRoot.get("typeRocher"), typeRocheParameter);
		} else {
			predicateRoche = builder.conjunction();
		}

		Predicate predicateSecteur = null;
		if (Optional.ofNullable(numberSecteur).isPresent()) {	
			predicateSecteur = builder.equal(builder.size(siteRoot.get("secteurs")), sizeSecteurParameter);
		} else {
			predicateSecteur = builder.conjunction();
		}
		
		Query<Site> query;
		
		// Ajout des prédicats au prédicat final
		Predicate finalPredicate = builder.and(predicateLieu, predicateRoche, predicateSecteur);
		criteria.where(finalPredicate);

		query = getCurrentSession().createQuery(criteria);

		if (numberSecteur != null) 
			query.setParameter(sizeSecteurParameter, numberSecteur);
		
		if (typeRoche != null)
			query.setParameter(typeRocheParameter, typeRoche);
		
		List<Site> sites = query.getResultList();
		return sites;

	}
	
	public Long createSite(String nomSite, String lieuSite, Integer hauteurSite, Boolean official, String descriptionSite, TypeRocher typeRoche) {		
		
		Site site = new Site();		
		site.setNom(nomSite);
		site.setLieu(lieuSite);
		site.setHauteurMax(hauteurSite);
		site.setTaguerOfficiel(official);
		site.setDescription(descriptionSite);
		site.setTypeRocher(typeRoche);
		
		Long id = (Long) getCurrentSession().save(site);
		return id;

	}

}
