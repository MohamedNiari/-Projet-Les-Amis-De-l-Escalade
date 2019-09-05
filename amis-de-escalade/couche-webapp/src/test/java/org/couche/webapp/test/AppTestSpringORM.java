package org.couche.webapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.couche.consumer.dao.interfaces.DaoInterface;
import org.couche.model.entities.Utilisateur;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTestSpringORM {

	public static void main(String[] args) throws ParseException {

		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		DaoInterface utilisateurDao = (DaoInterface) context.getBean("utilisateurDao");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("Niari4");
		utilisateur.setAdresseMail("mniari@openclassroom.com");
		utilisateur.setIdentifiant("A287755ORM");
		utilisateur.setMotDePasse("bonjour");
		utilisateur.setDateInscription(dateFormat.parse("04-09-2019"));
		utilisateur.setMembreAssociation(true);
		utilisateur.setPrenom("Mohamed4");
		utilisateur.setVille("Sochaux");
		utilisateur.setPays("France");
		
		utilisateurDao.create(utilisateur);

	}

}
