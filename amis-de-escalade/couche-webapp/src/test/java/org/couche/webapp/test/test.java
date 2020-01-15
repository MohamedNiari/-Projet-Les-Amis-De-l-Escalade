package org.couche.webapp.test;

import org.couche.business.services.SiteService;

public class test {

	public static void main(String[] args) throws Exception {

		String lien = "http://localhost:8080/SiteEscalade/ConfirmationReservation";
		
		System.out.println(lien.substring(0,lien.lastIndexOf("/")));

	}

	static void deleteSite(Long debut, Long fin) {
		SiteService siteService = new SiteService();
		for (long i = debut; i < fin; i++)
			siteService.delete(i);
	}
}
