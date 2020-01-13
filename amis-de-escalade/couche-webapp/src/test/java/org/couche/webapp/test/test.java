package org.couche.webapp.test;

import org.couche.business.services.SiteService;
import org.couche.business.services.TopoService;
import org.couche.business.services.UtilisateurService;
import org.couche.consumer.dao.implementation.ReservationDaoImplementation;
import org.couche.model.entities.Topo;
import org.couche.model.entities.Utilisateur;

public class test {

	public static void main(String[] args) throws Exception {

		/*ReservationDaoImplementation reservationDaoImplementation = new ReservationDaoImplementation();

		reservationDaoImplementation.openCurrentSession();

		TopoService topoService = new TopoService();
		Topo topo = topoService.findById(2L);

		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = utilisateurService.findById(2L);

		System.out.println(reservationDaoImplementation.isTopoEnAttente(topo, utilisateur));
		reservationDaoImplementation.closeCurrentSession();

		/*
		 * UtilisateurService utilisateurService = new UtilisateurService(); Utilisateur
		 * utilisateur = utilisateurService.findByEmail("mniari@openclassroom.com");
		 * 
		 * SiteService siteService = new SiteService(); Site site3 =
		 * siteService.findById(1L); Site site4 = siteService.findById(2L);
		 * 
		 * site3.setUtilisateur(utilisateur); site4.setUtilisateur(utilisateur);
		 * 
		 * siteService.update(site3); siteService.update(site4);
		 */
		
		

	}

	static void deleteSite(Long debut, Long fin) {
		SiteService siteService = new SiteService();
		for (long i = debut; i < fin; i++)
			siteService.delete(i);
	}
}
