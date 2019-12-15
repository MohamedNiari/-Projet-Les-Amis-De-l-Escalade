package org.couche.webapp.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Utilisateur;

/**
 * Servlet implementation class rechercheSite
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Map<String, String> erreurs = new HashMap<String, String>();
		HttpSession session = request.getSession();
		Boolean defaultOpenRegister = false;

		String prenom = request.getParameter("prenomInscription");
		String nom = request.getParameter("nomInscription");
		String email = request.getParameter("emailInscription");
		String motDePasse = request.getParameter("motDePasseInscription");
		String confirmation = request.getParameter("motDePasseConfirmationInscription");
		String ville = request.getParameter("villeInscription");
		String pays = request.getParameter("paysInscription");

		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = new Utilisateur();

		try {
			utilisateurService.validation(prenom, "Prenom");
		} catch (Exception e) {
			erreurs.put("prenom", e.getMessage());
		}
		utilisateur.getPrenoms().add(prenom);

		try {
			utilisateurService.validation(nom, "Nom");
		} catch (Exception e) {
			erreurs.put("nom", e.getMessage());
		}
		utilisateur.setNom(nom);

		try {
			utilisateurService.validationEmail(email);
		} catch (Exception e) {
			erreurs.put("email", e.getMessage());
		}
		utilisateur.setAdresseMail(email);

		try {
			utilisateurService.validationMotDePasse(motDePasse, confirmation);
		} catch (Exception e) {
			erreurs.put("motDePasse", e.getMessage());
		}
		utilisateur.setMotDePasse(motDePasse);

		try {
			utilisateurService.validation(ville, "Ville");
		} catch (Exception e) {
			erreurs.put("ville", e.getMessage());
		}
		utilisateur.setVille(ville);

		try {
			utilisateurService.validation(pays, "Pays");
		} catch (Exception e) {
			erreurs.put("pays", e.getMessage());
		}
		utilisateur.setPays(pays);

		if (erreurs.isEmpty()) {
			utilisateur.setDateInscription(dateFormat.format(date));
			utilisateur.setMembreAssociation(false);
			utilisateurService.create(utilisateur);
			
			session.setAttribute("connexionOk", true);
			session.setAttribute("nom", utilisateur.getNom());
			session.setAttribute("prenom", utilisateur.getPrenoms().iterator().next());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListeDesSites");
			dispatcher.forward(request, response);

		} else {
			defaultOpenRegister = true;
			
			request.setAttribute("defaultOpenRegister", defaultOpenRegister);
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("prenom", prenom);
			request.setAttribute("nom", nom);
			request.setAttribute("email", email);
			request.setAttribute("motDePasse", motDePasse);
			request.setAttribute("confirmation", confirmation);
			request.setAttribute("ville", ville);
			request.setAttribute("pays", pays);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginRegistering.jsp");
			dispatcher.forward(request, response);
		}

	}

}
