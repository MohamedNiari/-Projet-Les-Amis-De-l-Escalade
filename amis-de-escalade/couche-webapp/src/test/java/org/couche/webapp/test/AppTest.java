package org.couche.webapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppTest {

	public static void main(String[] args) throws ParseException {

		UtilisateurService utilisateurService = new UtilisateurService();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Utilisateur utilisateurTest = new Utilisateur("Niari4", "mniari@openclassroom.com", "A287755", "bonjour",
				dateFormat.parse("04-09-2019"), true, "Mohamed4", "Sochaux", "France");

		utilisateurService.create(utilisateurTest);

	}

}
