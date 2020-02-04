package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.TopoDaoImplementation;
import org.couche.model.entities.Site;
import org.couche.model.entities.Topo;
import org.couche.model.entities.Utilisateur;

public class TopoService {

	private static TopoDaoImplementation topoDao;

	public TopoService() {
		topoDao = new TopoDaoImplementation();
	}

	public void create(Topo topo) {
		topoDao.openCurrentSessionwithTransaction();
		topoDao.create(topo);
		topoDao.closeCurrentSessionwithTransaction();
	}
	
	public void persist(Topo topo) {
		topoDao.openCurrentSessionwithTransaction();
		topoDao.persist(topo);
		topoDao.closeCurrentSessionwithTransaction();
	}

	public void update(Topo topo) {
		topoDao.openCurrentSessionwithTransaction();
		topoDao.update(topo);
		topoDao.closeCurrentSessionwithTransaction();
	}
	
	public void merge(Topo topo) {
		topoDao.openCurrentSessionwithTransaction();
		topoDao.merge(topo);
		topoDao.closeCurrentSessionwithTransaction();
	}

	public Topo findById(Long id) {
		topoDao.openCurrentSession();
		Topo topo = topoDao.findById(id);
		topoDao.closeCurrentSession();
		return topo;
	}

	public void delete(Long id) {
		topoDao.openCurrentSessionwithTransaction();
		Topo topo = topoDao.findById(id);
		topoDao.delete(topo);
		topoDao.closeCurrentSessionwithTransaction();
	}

	public List<Topo> findAll() {
		topoDao.openCurrentSession();
		List<Topo> topos = topoDao.findAll();
		topoDao.closeCurrentSession();
		return topos;
	}

	public void deleteAll() {
		topoDao.openCurrentSessionwithTransaction();
		topoDao.deleteAll();
		topoDao.closeCurrentSessionwithTransaction();
	}
	
	public List<Topo> findByUser(Utilisateur utilisateur) {
		topoDao.openCurrentSession();
		List<Topo> topos = topoDao.findByUser(utilisateur);
		topoDao.closeCurrentSession();
		return topos;
	}
	
	//Topos disponible pour un utilisateur en particulier
	public List<Topo> disponible(Utilisateur utilisateur) {
		topoDao.openCurrentSession();
		List<Topo> topos = topoDao.disponible(utilisateur);
		topoDao.closeCurrentSession();
		return topos;
	}

}
