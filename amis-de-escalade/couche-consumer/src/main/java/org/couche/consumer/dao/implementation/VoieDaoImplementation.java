package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.VoieDaoInterface;
import org.couche.model.entities.Voie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class VoieDaoImplementation implements VoieDaoInterface<Voie, Long> {

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
	public void create(Voie entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Voie entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(Voie entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voie> findAll() {
		List<Voie> voies = (List<Voie>) getCurrentSession().createQuery("from Book").list();
		return voies;
	}

	@Override
	public void deleteAll() {
		List<Voie> entityList = findAll();
		for (Voie entity : entityList) {
			delete(entity);
		}
	}

	@Override
	public Voie findById(Long id) {
		Voie voies = (Voie) getCurrentSession().get(Voie.class, id);
		return voies;
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
