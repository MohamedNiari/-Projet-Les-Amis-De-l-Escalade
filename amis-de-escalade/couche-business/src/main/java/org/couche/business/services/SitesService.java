package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.SitesDaoImplementation;
import org.couche.model.entities.Sites;

public class SitesService {

	private static SitesDaoImplementation sitesDao;

	public void create(Sites entity) {
		sitesDao.openCurrentSessionwithTransaction();
		sitesDao.create(entity);
		sitesDao.closeCurrentSessionwithTransaction();
	}

	public void update(Sites entity) {
		sitesDao.openCurrentSessionwithTransaction();
		sitesDao.update(entity);
		sitesDao.closeCurrentSessionwithTransaction();
	}

	public Sites findById(Long id) {
		sitesDao.openCurrentSession();
		Sites site = sitesDao.findById(id);
		sitesDao.closeCurrentSession();
		return site;
	}

	public void delete(Long id) {
		sitesDao.openCurrentSessionwithTransaction();
		Sites site = sitesDao.findById(id);
		sitesDao.delete(site);
		sitesDao.closeCurrentSessionwithTransaction();
	}

	public List<Sites> findAll() {
		sitesDao.openCurrentSession();
		List<Sites> sites = sitesDao.findAll();
		sitesDao.closeCurrentSession();
		return sites;
	}

	public void deleteAll() {
		sitesDao.openCurrentSessionwithTransaction();
		sitesDao.deleteAll();
		sitesDao.closeCurrentSessionwithTransaction();
	}

}
