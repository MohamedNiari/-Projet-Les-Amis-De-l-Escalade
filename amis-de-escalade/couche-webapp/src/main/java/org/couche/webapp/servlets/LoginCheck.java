package org.couche.webapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.couche.business.services.UtilisateurService;

/**
 * Servlet implementation class rechercheSite
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String connexionKo = null;

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
		System.out.println("doGet connexionKo : " + connexionKo);
		if (connexionKo != null)
			request.removeAttribute(connexionKo);
		response.sendRedirect("/SiteEscalade/loginRegistering.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Boolean etatConnexion;
		String adresseMail = request.getParameter("adresseMail");
		String motDePasse = request.getParameter("motDePasse");

		HttpSession session = request.getSession();

		UtilisateurService utilisateurService = new UtilisateurService();

		etatConnexion = utilisateurService.checkLogin(motDePasse, adresseMail);

		if (etatConnexion) {
			System.out.println("connexion ok");
		} else {
			connexionKo = "Votre adresse mail ou votre mot de passe est incorrect.";
			request.setAttribute("connexionKo", connexionKo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginRegistering.jsp");
			dispatcher.forward(request, response);
		}

		System.out.println("doPost connexionKo : " + connexionKo);
		System.out.println("etatConnexion : " + etatConnexion);

	}

}
