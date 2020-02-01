package org.couche.webapp.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.couche.business.services.ReservationService;
import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Reservation;
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginRegistering.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Boolean etatConnexion = false;
		String connexionKo = null;
		Set<String> prenoms = new HashSet<String>();

		String adresseMail = request.getParameter("adresseMail");
		String motDePasse = request.getParameter("motDePasse");

		HttpSession session = request.getSession();

		UtilisateurService utilisateurService = new UtilisateurService();
		ReservationService reservationService = new ReservationService();
		Utilisateur utilisateur = new Utilisateur();
		Integer nombreReservation = 0;

		if (utilisateurService.findByEmail(adresseMail) != null) {

			utilisateur = utilisateurService.findByEmail(adresseMail);
			prenoms = utilisateur.getPrenoms();
			etatConnexion = utilisateurService.checkLogin(motDePasse, adresseMail);

			// Récupération du nombre de réservation en attente
			List<Reservation> reservations = reservationService.listeReservationEnAttente(utilisateur);
			nombreReservation = reservations.size();

		}

		if (etatConnexion) {

			session.setAttribute("connexionOk", true);
			session.setAttribute("nom", utilisateur.getNom());
			session.setAttribute("prenom", prenoms.iterator().next());
			session.setAttribute("adresseMail", adresseMail);
			session.setAttribute("membreAssociation", utilisateur.getMembreAssociation());
			session.setAttribute("nombreReservation", nombreReservation);

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
