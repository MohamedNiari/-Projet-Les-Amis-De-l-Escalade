package org.couche.webapp.test;

import java.util.List;

import org.couche.business.services.SiteService;
import org.couche.business.services.UtilisateurService;
import org.couche.consumer.dao.implementation.CommentaireDaoImplementation;
import org.couche.model.entities.Commentaire;
import org.couche.model.entities.Site;
import org.couche.model.entities.Utilisateur;

public class test {

	public static void main(String[] args) throws Exception {

		//deleteSite(20L, 23L);
		UtilisateurService utilisateurService = new UtilisateurService();

		Utilisateur utilisateurTest = new Utilisateur("Smith", "lsmith@openclassroom.com", "bonjour", "01/01/2020",
				false, "Bern", "Suisse");

		utilisateurTest.getPrenoms().add("Lauren");
		
		utilisateurService.create(utilisateurTest);

	}

	static void deleteSite(Long debut, Long fin) {
		SiteService siteService = new SiteService();
		for (long i = debut; i < fin; i++)
			siteService.delete(i);
	}
}
