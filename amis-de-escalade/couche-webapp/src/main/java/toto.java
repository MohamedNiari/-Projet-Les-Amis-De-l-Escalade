
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.couche.model.entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class toto {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Utilisateur.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {

			// create the objects
			Utilisateur utilisateurTest = new Utilisateur("Niari2", "mniari@openclassroom.com", "A248757", "bonjour",
					dateFormat.parse("04-09-2019"), true, "Mohamed2", "Sochaux", "France");

			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + utilisateurTest);
			session.save(utilisateurTest);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			// add clean up code
			session.close();

			factory.close();
		}

	}

}
