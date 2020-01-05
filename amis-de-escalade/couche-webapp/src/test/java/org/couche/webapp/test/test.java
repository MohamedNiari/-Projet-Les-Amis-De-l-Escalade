package org.couche.webapp.test;

import org.couche.business.services.SiteService;
import org.couche.business.services.TopoService;

public class test {

	public static void main(String[] args) throws Exception {
		TopoService topoService = new TopoService();
		topoService.delete(3L);

	}

	static void deleteSite(Long debut, Long fin) {
		SiteService siteService = new SiteService();
		for (long i = debut; i < fin; i++)
			siteService.delete(i);
	}
}
