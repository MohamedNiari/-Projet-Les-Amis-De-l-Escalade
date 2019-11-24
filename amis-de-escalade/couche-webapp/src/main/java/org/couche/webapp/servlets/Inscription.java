package org.couche.webapp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated constructor stub
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

		Map<String, String> erreurs = new HashMap<String, String>();
		String resultat;

		String nom = request.getParameter("nomInscription");
		String email = request.getParameter("emailInscription");
		String motDePasse = request.getParameter("motDePasseInscription");
		String confirmation = request.getParameter("motDePasseConfirmationInscription");
		String ville = request.getParameter("villeInscription");
		String pays = request.getParameter("paysInscription");

		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = new Utilisateur();

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
			resultat = "Succès de l'inscription.";
		} else {
			resultat = "Échec de l'inscription.";
		}

		if (erreurs.isEmpty()) {
			utilisateurService.create(utilisateur);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListeDesSites");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("utilisateur", utilisateur);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginRegistering.jsp");
			dispatcher.forward(request, response);
		}

	}

}
