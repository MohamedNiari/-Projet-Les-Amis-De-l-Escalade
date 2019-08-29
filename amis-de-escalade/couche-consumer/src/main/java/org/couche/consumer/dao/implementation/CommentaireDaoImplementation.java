package org.couche.consumer.dao.implementation;

import java.util.List;

import org.couche.consumer.dao.interfaces.CommentaireDaoInterface;
import org.couche.model.entities.Commentaire;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CommentaireDaoImplementation implements CommentaireDaoInterface<Commentaire, Long> {

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
	public void create(Commentaire entity) {
		getCurrentSession().save(entity);

	}

	@Override
	public void update(Commentaire entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(Commentaire entity) {
		getCurrentSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commentaire> findAll() {
		List<Commentaire> commentaires = (List<Commentaire>) getCurrentSession().createQuery("from Book").list();
	        return commentaires;
	}

	@Override
	public void deleteAll() {
        List<Commentaire> entityList = findAll();
        for (Commentaire entity : entityList) {
            delete(entity);
        }
	}

	@Override
	public Commentaire findById(Long id) {
		Commentaire commentaire = (Commentaire) getCurrentSession().get(Commentaire.class, id);
        return commentaire; 
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
