package org.couche.webapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.couche.business.services.CommentaireService;
import org.couche.model.entities.Commentaire;

public class AppTest {

	public static void main(String[] args) throws ParseException {

		CommentaireService CommentaireService = new CommentaireService();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Commentaire commentaire1 = new Commentaire("Trop fatigué aurjoud'hui", dateFormat.parse("29-04-2014"));
		Commentaire commentaire2 = new Commentaire("C'était long la montée", dateFormat.parse("15-06-2006"));
		Commentaire commentaire3 = new Commentaire("On aurait du se scinder en 2 groupes",
				dateFormat.parse("19-01-2019"));

		CommentaireService.create(commentaire1);

	}

}
