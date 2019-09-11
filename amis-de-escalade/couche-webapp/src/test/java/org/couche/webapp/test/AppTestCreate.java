package org.couche.webapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.couche.business.services.TopoService;
import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Topo;
import org.couche.model.entities.Utilisateur;

public class AppTestCreate {

	public static void main(String[] args) throws ParseException {

		// test pour la table utilisateur
		UtilisateurService utilisateurService = new UtilisateurService();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Utilisateur utilisateurTest = new Utilisateur("Niari4", "mniari@openclassroom.com", "A287755", "bonjour",
				dateFormat.parse("04-09-2019"), true, "Mohamed4", "Sochaux", "France");

		utilisateurService.create(utilisateurTest);

		// test pour la table topo
		TopoService topoService = new TopoService();

		Topo topoTest = new Topo("Escalade en Savoie2",
				"Dans l’avant-pays savoyard, à la limite entre la Savoie et l’Ain, le Rhône a creusé sur 1 km le défilé de PierreChâtel. En rive gauche et rive droite, les gorges sont bordées de falaises qui surplombent les eaux vertes du fleuve.",
				"La Savoie2", dateFormat.parse("04-09-2019"), true);
		
		topoService.create(topoTest, utilisateurTest);

	}

}
