package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.SitesDaoImplementation;
import org.couche.consumer.dao.implementation.UtilisateurDaoImplementation;
import org.couche.model.entities.Site;

public class SitesService {

	private static SitesDaoImplementation sitesDao;
	
	public SitesService() {
		sitesDao = new SitesDaoImplementation();
	}

	public void create(Site entity) {
		sitesDao.openCurrentSessionwithTransaction();
		sitesDao.create(entity);
		sitesDao.closeCurrentSessionwithTransaction();
	}

	public void update(Site entity) {
		sitesDao.openCurrentSessionwithTransaction();
		sitesDao.update(entity);
		sitesDao.closeCurrentSessionwithTransaction();
	}

	public Site findById(Long id) {
		sitesDao.openCurrentSession();
		Site site = sitesDao.findById(id);
		sitesDao.closeCurrentSession();
		return site;
	}

	public void delete(Long id) {
		sitesDao.openCurrentSessionwithTransaction();
		Site site = sitesDao.findById(id);
		sitesDao.delete(site);
		sitesDao.closeCurrentSessionwithTransaction();
	}

	public List<Site> findAll() {
		sitesDao.openCurrentSession();
		List<Site> sites = sitesDao.findAll();
		sitesDao.closeCurrentSession();
		return sites;
	}

	public void deleteAll() {
		sitesDao.openCurrentSessionwithTransaction();
		sitesDao.deleteAll();
		sitesDao.closeCurrentSessionwithTransaction();
	}

}
