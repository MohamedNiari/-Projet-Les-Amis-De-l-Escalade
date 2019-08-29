package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.SitesDaoInterface;
import org.couche.model.entities.Sites;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SitesDaoImplementation implements SitesDaoInterface<Sites, Long> {

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
	public void create(Sites entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Sites entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(Sites entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sites> findAll() {
		List<Sites> sites = (List<Sites>) getCurrentSession().createQuery("from Book").list();
		return sites;
	}

	@Override
	public void deleteAll() {
		List<Sites> entityList = findAll();
		for (Sites entity : entityList) {
			delete(entity);
		}
	}

	@Override
	public Sites findById(Long id) {
		Sites sites = (Sites) getCurrentSession().get(Sites.class, id);
		return sites;
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
