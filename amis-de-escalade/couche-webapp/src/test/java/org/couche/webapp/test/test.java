package org.couche.webapp.test;

import java.util.List;

import org.couche.business.services.ReservationService;
import org.couche.business.services.SiteService;
import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Reservation;
import org.couche.model.entities.Utilisateur;

public class test {

	public static void main(String[] args) throws Exception {

		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = utilisateurService.findByEmail("mniari@openclassroom.com");

		ReservationService reservationService = new ReservationService();

		List<Reservation> reservations = reservationService.listeReservationEnAttente(utilisateur);

		for (Reservation reservation : reservations) {
			
			reservation.getId();
			reservation.getTopo();
			reservation.getUtilisateur();

		}

	}

	static void deleteSite(Long debut, Long fin) {
		SiteService siteService = new SiteService();
		for (long i = debut; i < fin; i++)
			siteService.delete(i);
	}
}
