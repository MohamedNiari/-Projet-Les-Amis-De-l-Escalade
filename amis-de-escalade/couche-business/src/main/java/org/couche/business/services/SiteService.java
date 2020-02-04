package org.couche.business.services;

import java.util.List;

import org.couche.consumer.dao.implementation.SiteDaoImplementation;
import org.couche.model.entities.Reservation;
import org.couche.model.entities.Site;
import org.couche.model.entities.Topo;
import org.couche.model.entities.TypeRocher;
import org.couche.model.entities.Utilisateur;

import com.sun.istack.Nullable;

public class SiteService {

	private static SiteDaoImplementation siteDao;

	public SiteService() {
		siteDao = new SiteDaoImplementation();
	}

	public Long createSite(String nomSite, String lieuSite, Integer hauteurSite, Boolean official, String descriptionSite, TypeRocher typeRoche) {
		siteDao.openCurrentSessionwithTransaction();
		Long siteId = siteDao.createSite(nomSite, lieuSite, hauteurSite, official, descriptionSite, typeRoche);
		siteDao.closeCurrentSessionwithTransaction();
		return siteId;
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
	
	public Site findByName(String nom) {
		siteDao.openCurrentSession();
		Site site = siteDao.findByName(nom);
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
	
	public void validationNomSite(Site site) {
		siteDao.openCurrentSessionwithTransaction();
		siteDao.validationNomSite(site);
		siteDao.merge(site);
		siteDao.closeCurrentSessionwithTransaction();
	}

	public List<Site> searchSite(String lieu, TypeRocher typeRoche, Integer numberSecteur) {		
		siteDao.openCurrentSession();
		List<Site> sites = siteDao.searchSite(lieu, typeRoche, numberSecteur);
		siteDao.closeCurrentSession();
		return sites;
	}
	
	public List<Site> findByUser(Utilisateur utilisateur) {
		siteDao.openCurrentSession();
		List<Site> sites = siteDao.findByUser(utilisateur);
		siteDao.closeCurrentSession();
		return sites;
	}


}
