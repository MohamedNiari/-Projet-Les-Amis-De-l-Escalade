package org.couche.webapp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/SiteEscalade/loginRegistering.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Boolean etatConnexion;
		String connexionKo = null;
		Set<String> prenoms = new HashSet<String>();

		String adresseMail = request.getParameter("adresseMail");
		String motDePasse = request.getParameter("motDePasse");

		HttpSession session = request.getSession();

		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = utilisateurService.findByEmail(adresseMail);

		prenoms = utilisateur.getPrenoms();
		etatConnexion = utilisateurService.checkLogin(motDePasse, adresseMail);

		if (etatConnexion) {
			session.setAttribute("connexionOk", true);
			session.setAttribute("nom", utilisateur.getNom());
			session.setAttribute("prenom", prenoms.iterator().next());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListeDesSites");
			dispatcher.forward(request, response);

		} else {
			connexionKo = "Votre adresse mail ou votre mot de passe est incorrect.";
			request.setAttribute("connexionKo", connexionKo);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginRegistering.jsp");
			dispatcher.forward(request, response);

		}

	}

}
