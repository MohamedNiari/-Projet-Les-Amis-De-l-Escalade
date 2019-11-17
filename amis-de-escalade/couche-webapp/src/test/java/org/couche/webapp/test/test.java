package org.couche.webapp.test;

import java.util.List;

import org.couche.business.services.SiteService;
import org.couche.model.entities.Site;
import org.couche.model.entities.TypeRocher;
import org.couche.model.entities.Utilisateur;

public class test {

	public static void main(String[] args) {
		SiteService siteService = new SiteService();
		List<Site> sites = siteService.searchSite("", null, null);

		sites.forEach(x -> System.out.println(x.getNom()));

	}

}
