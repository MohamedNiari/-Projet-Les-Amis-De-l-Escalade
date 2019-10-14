package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.SiteDaoImplementation;
import org.couche.model.entities.Site;
import org.couche.model.entities.Topo;

public class SiteService {

	private static SiteDaoImplementation siteDao;

	public SiteService() {
		siteDao = new SiteDaoImplementation();
	}

	public void create(Site site) {
		siteDao.openCurrentSessionwithTransaction();
		siteDao.create(site);
		siteDao.closeCurrentSessionwithTransaction();
	}

	public void update(Site site) {
		siteDao.openCurrentSessionwithTransaction();
		siteDao.update(site);
		siteDao.closeCurrentSessionwithTransaction();
	}

	public Site findById(Long id) {
		siteDao.openCurrentSession();
		Site site = siteDao.findById(id);
		siteDao.closeCurrentSession();
		return site;
	}

	public void delete(Long id) {
		siteDao.openCurrentSessionwithTransaction();
		Site site = siteDao.findById(id);
		siteDao.delete(site);
		siteDao.closeCurrentSessionwithTransaction();
	}

	public List<Site> findAll() {
		siteDao.openCurrentSession();
		List<Site> sites = siteDao.findAll();
		siteDao.closeCurrentSession();
		return sites;
	}

	public void deleteAll() {
		siteDao.openCurrentSessionwithTransaction();
		siteDao.deleteAll();
		siteDao.closeCurrentSessionwithTransaction();
	}
	


}
