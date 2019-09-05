package org.couche.consumer.dao.implementation;

import java.util.List;


import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("utilisateurDao")
public class UtilisateurDaoImplementationSpringOrm implements DaoInterface<Utilisateur, Long> {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public void create(Utilisateur entity) {
		hibernateTemplate.save(entity);

	}

	@Override
	public void update(Utilisateur entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Utilisateur entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
