package org.couche.webapp.test;

import org.couche.business.services.SiteService;

public class test {

	public static void main(String[] args) throws Exception {

		SiteService siteService = new SiteService();
		for (long i = 94L; i < 97L; i++)
			siteService.delete(i);

		
		
	}
}
