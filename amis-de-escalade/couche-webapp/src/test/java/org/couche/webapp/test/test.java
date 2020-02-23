package org.couche.webapp.test;

import org.couche.business.services.SiteService;
import org.couche.model.entities.Site;

public class test {

	public static void main(String[] args) throws Exception {

		SiteService siteservice = new SiteService();
		siteservice.delete(6L);

	}

}
