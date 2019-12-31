package org.couche.webapp.test;

import org.couche.business.services.SiteService;

public class test {

	public static void main(String[] args) throws Exception {

		deleteSite(20L, 23L);

	}

	static void deleteSite(Long debut, Long fin) {
		SiteService siteService = new SiteService();
		for (long i = debut; i < fin; i++)
			siteService.delete(i);
	}
}
