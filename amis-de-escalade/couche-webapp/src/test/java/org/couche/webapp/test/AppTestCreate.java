package org.couche.webapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.couche.business.services.SiteService;
import org.couche.business.services.TopoService;
import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Site;
import org.couche.model.entities.Topo;
import org.couche.model.entities.TypeRocher;
import org.couche.model.entities.Utilisateur;

public class AppTestCreate {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		// test pour la table utilisateur
		UtilisateurService utilisateurService = new UtilisateurService();

		Utilisateur utilisateurTest = new Utilisateur("Niari", "mniari@openclassroom.com", "A287755", "bonjour",
				dateFormat.parse("04-09-2019"), true, "Mohamed4", "Sochaux", "France");

		utilisateurService.create(utilisateurTest);

		// test pour la table topo
		TopoService topoService = new TopoService();

		Topo topoTest = new Topo("Escalade en Savoie2",
				"Dans l’avant-pays savoyard, à la limite entre la Savoie et l’Ain, le Rhône a creusé sur 1 km le défilé de PierreChâtel. En rive gauche et rive droite, les gorges sont bordées de falaises qui surplombent les eaux vertes du fleuve.",
				"La Savoie2", dateFormat.parse("04-09-2019"), true, utilisateurTest);

		topoService.create(topoTest);

		// test pour la table site
		SiteService siteService = new SiteService();

		Site siteTest = new Site("site de bellevue", 42, "Privas", false,
				"Situé presque au fond de la vallée de la Vallouise, au Nord de L’Argentière la Bessée, existe-t-il meilleur endroit pour grimper en été ? Peut-être, mais Ailefroide a quand même de quoi convaincre",
				"/couche-webapp/src/main/webapp/WEB-INF/img/siteDeBellevue.jpg", TypeRocher.Granite, topoTest);

		Site siteTest2 = new Site("Ablon", 74, "Thorens", true,
				"La falaise appartient à un vallon de calcaire urgonien, parvenu jusqu’à nous sous forme de murs verticaux ou légèrement déversants, compacts et finement ciselés d’une multitude de cannelures et de picots, qui sont d’ailleurs la marque de fabrique d’Ablon.",
				"/couche-webapp/src/main/webapp/WEB-INF/img/Ablon.jpg", TypeRocher.Gneiss, topoTest);

		siteService.create(siteTest);
		siteService.create(siteTest2);
	}

}
