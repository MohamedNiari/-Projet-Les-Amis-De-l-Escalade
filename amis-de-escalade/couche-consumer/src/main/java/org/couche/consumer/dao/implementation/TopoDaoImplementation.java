package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.TopoDaoInterface;
import org.couche.model.entities.Topo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class TopoDaoImplementation implements TopoDaoInterface<Topo, Long> {

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
		List<Topo> topos = (List<Topo>) getCurrentSession().createQuery("from Book").list();
		return topos;
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
		Topo topos = (Topo) getCurrentSession().get(Topo.class, id);
		return topos;
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
