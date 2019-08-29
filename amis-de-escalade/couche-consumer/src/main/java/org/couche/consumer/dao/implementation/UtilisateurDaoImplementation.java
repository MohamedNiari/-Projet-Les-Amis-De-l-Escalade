package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.UtilisateurDaoInterface;
import org.couche.model.entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtilisateurDaoImplementation implements UtilisateurDaoInterface<Utilisateur, Long> {

	private Session currentSession;

	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

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
		List<Utilisateur> utilisateurs = (List<Utilisateur>) getCurrentSession().createQuery("from Book").list();
		return utilisateurs;
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
		Utilisateur utilisateurs = (Utilisateur) getCurrentSession().get(Utilisateur.class, id);
		return utilisateurs;
	}

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

}
