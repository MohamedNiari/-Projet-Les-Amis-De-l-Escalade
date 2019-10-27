package org.couche.webapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.couche.business.services.LongueurService;
import org.couche.business.services.SecteurService;
import org.couche.business.services.SiteService;
import org.couche.business.services.TopoService;
import org.couche.business.services.UtilisateurService;
import org.couche.business.services.VoieService;
import org.couche.model.entities.Longueur;
import org.couche.model.entities.Secteur;
import org.couche.model.entities.Site;
import org.couche.model.entities.Topo;
import org.couche.model.entities.TypeRocher;
import org.couche.model.entities.Utilisateur;
import org.couche.model.entities.Voie;

public class AppTestCreate {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		// test pour la table utilisateur
		UtilisateurService utilisateurService = new UtilisateurService();

		Utilisateur utilisateurTest = new Utilisateur("Niari", "mniari@openclassroom.com", "A287755", "bonjour",
				dateFormat.parse("04-09-2019"), true, "Sochaux", "France");

		utilisateurTest.getPrenoms().add("Mohamed");
		utilisateurTest.getPrenoms().add("James");
		utilisateurTest.getPrenoms().add("Tayeb");

		utilisateurService.create(utilisateurTest);

		// test pour la table topo
		TopoService topoService = new TopoService();

		Topo topoTest = new Topo("Escalade en Savoie2",
				"Rive gauche, le rocher passe à l’ombre à 12h30 mais les arbres cachent assez bien le soleil avant. On peut donc y grimper en été, même le matin hors période de canicule.",
				"La Savoie2", dateFormat.parse("04-09-2019"), true, utilisateurTest);

		topoService.create(topoTest);

		// test pour la table site
		SiteService siteService = new SiteService();

		Site siteTest = new Site("Bellevue", 42, "Privas", false,
				"Pas beaucoup de voies pour l’instant mais il y a encore un peu de potentiel, il est donc probable que de nouvelles voies soient équipées, voire d’autres secteurs.",
				TypeRocher.Granite, topoTest);

		siteTest.getUrlImages().add("img/Ablon.jpg");
		siteTest.getUrlImages().add("img/Ablon2.jpg");
		siteTest.getUrlImages().add("img/Ablon3.jpg");

		Site siteTest2 = new Site("Ablon", 74, "Thorens", true,
				"C’est LA FALAISE incontournable de la région par sa taille, sa grimpe et sa vue. Son orientation ouest, et le peu d’ombre au pied de la falaise, font que l’on peut y grimper toute l’année.",
				TypeRocher.Gneiss, topoTest);

		siteTest2.getUrlImages().add("img/Bellevue.jpg");
		siteTest2.getUrlImages().add("img/Bellevue2.png");
		siteTest2.getUrlImages().add("img/Bellevue3.png");

		Site siteTest3 = new Site("Le Teillon", 69, "Oullins", true,
				"Site à la mode dans les années 1970 pour aller taquiner du piton, le Teillon aujourd’hui ne parle plus à personne, éclipsé qu’il est dans l’ombre médiatique et photogénique de sa célébrissime voisine.",
				TypeRocher.Calcaire, topoTest);

		siteTest3.getUrlImages().add("img/LeTeillon.jpg");
		siteTest3.getUrlImages().add("img/LeTeillon2.jpg");
		siteTest3.getUrlImages().add("img/LeTeillon3.jpg");

		siteService.create(siteTest);
		siteService.create(siteTest2);
		siteService.create(siteTest3);

		// test pour la table secteur
		SecteurService secteurService = new SecteurService();
		Secteur secteurTest = new Secteur("La vertical", 1, "Enormes cannelures", siteTest);
		Secteur secteurTest2 = new Secteur("Saint-Georges", 2, "Son calcaire est superbe et unique", siteTest);
		Secteur secteurTest3 = new Secteur("Autracien", 3, "Le rocher est finement sculpté ", siteTest);

		secteurService.create(secteurTest);
		secteurService.create(secteurTest2);
		secteurService.create(secteurTest3);

		// test pour la table voie
		VoieService VoieService = new VoieService();
		Voie voieTest = new Voie(7, 1, secteurTest);
		Voie voieTest2 = new Voie(4, 2, secteurTest);
		Voie voieTest3 = new Voie(6, 3, secteurTest);
		Voie voieTest4 = new Voie(8, 4, secteurTest);
		Voie voieTest5 = new Voie(4, 1, secteurTest2);
		Voie voieTest6 = new Voie(5, 2, secteurTest2);

		VoieService.create(voieTest);
		VoieService.create(voieTest2);
		VoieService.create(voieTest3);
		VoieService.create(voieTest4);
		VoieService.create(voieTest5);
		VoieService.create(voieTest6);
		
		// test pour la table longueur
		LongueurService longueurService = new LongueurService();
		Longueur longueurTest = new Longueur(25, "4a", true, 1, voieTest);
		Longueur longueurTest2 = new Longueur(15, "5c", false, 2, voieTest);
		Longueur longueurTest3 = new Longueur(41, "5b", true, 3, voieTest);
		Longueur longueurTest4 = new Longueur(35, "4c", true, 4, voieTest);
		Longueur longueurTest5 = new Longueur(25, "5a", true, 5, voieTest);
		Longueur longueurTest6 = new Longueur(12, "5c", false, 6, voieTest);
		Longueur longueurTest7 = new Longueur(14, "5a", false, 7, voieTest);
		Longueur longueurTest8 = new Longueur(45, "7a", true, 1, voieTest2);
		Longueur longueurTest9 = new Longueur(14, "7c", false, 2, voieTest2);
		Longueur longueurTest10 = new Longueur(25, "8a", false, 3, voieTest2);
		Longueur longueurTest11 = new Longueur(32, "8b", true, 4, voieTest2);
		Longueur longueurTest12 = new Longueur(21, "8c", false, 1, voieTest3);
		Longueur longueurTest13 = new Longueur(18, "7b", false, 2, voieTest3);
		Longueur longueurTest14 = new Longueur(45, "7a", false, 3, voieTest3);
		Longueur longueurTest15 = new Longueur(14, "6c", true, 4, voieTest3);
		Longueur longueurTest16 = new Longueur(25, "8a", false, 5, voieTest3);
		Longueur longueurTest17 = new Longueur(32, "6c", false, 6, voieTest3);
		Longueur longueurTest18 = new Longueur(21, "7a", true, 1, voieTest4);
		Longueur longueurTest19 = new Longueur(11, "7b", true, 2, voieTest4);
		Longueur longueurTest20 = new Longueur(25, "5c", true, 3, voieTest4);
		Longueur longueurTest21 = new Longueur(17, "6b", false, 4, voieTest4);
		Longueur longueurTest22 = new Longueur(14, "6c", true, 5, voieTest4);
		Longueur longueurTest23 = new Longueur(29, "7a", true, 6, voieTest4);
		Longueur longueurTest24 = new Longueur(4, "6c", true, 7, voieTest4);
		Longueur longueurTest25 = new Longueur(49, "6a", false, 8, voieTest4);


		longueurService.create(longueurTest);
		longueurService.create(longueurTest2);
		longueurService.create(longueurTest3);
		longueurService.create(longueurTest4);
		longueurService.create(longueurTest5);
		longueurService.create(longueurTest6);
		longueurService.create(longueurTest7);
		longueurService.create(longueurTest8);
		longueurService.create(longueurTest9);
		longueurService.create(longueurTest10);
		longueurService.create(longueurTest11);
		longueurService.create(longueurTest12);
		longueurService.create(longueurTest13);
		longueurService.create(longueurTest14);
		longueurService.create(longueurTest15);
		longueurService.create(longueurTest16);
		longueurService.create(longueurTest17);
		longueurService.create(longueurTest18);
		longueurService.create(longueurTest19);
		longueurService.create(longueurTest20);
		longueurService.create(longueurTest21);
		longueurService.create(longueurTest22);
		longueurService.create(longueurTest23);
		longueurService.create(longueurTest24);
		longueurService.create(longueurTest25);
		
	}

}
