package org.couche.webapp.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.couche.business.services.ReservationService;
import org.couche.business.services.TopoService;
import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Reservation;
import org.couche.model.entities.Topo;
import org.couche.model.entities.Utilisateur;

/**
 * Servlet implementation class MesTopos
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String adresseMail = (String) session.getAttribute("adresseMail");
		
		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = utilisateurService.findByEmail(adresseMail);
		
		TopoService topoService = new TopoService();
		ReservationService reservationService = new ReservationService();
		
		HashMap<Topo, Boolean> mapTopoAttente = new HashMap<Topo, Boolean>();
		List<Topo> topos = topoService.disponible();
		
		for(Topo topo : topos) {			
			mapTopoAttente.put(topo, reservationService.isTopoEnAttente(topo, utilisateur));			
		}
		
		for(Map.Entry<Topo, Boolean> entry : mapTopoAttente.entrySet()) {
			System.out.println("topo : " + entry.getKey().getNom());
			System.out.println("topoEnAttente : " + entry.getValue());			
		}
			
		
		request.setAttribute("topos", topos);
		request.setAttribute("mapTopoAttente", mapTopoAttente);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/topos-disponible.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) Mise à jour de la disponibilité d'un Topo
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST ReservationServlet");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String topoId = request.getParameter("topoId");

		HttpSession session = request.getSession(false);
		String adresseMail = (String) session.getAttribute("adresseMail");

		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = utilisateurService.findByEmail(adresseMail);

		TopoService topoService = new TopoService();
		Topo topo = topoService.findById(Long.parseLong(topoId));

		Reservation reservation = new Reservation();
		reservation.setAccepter(false);
		reservation.setProprietaire(topo.getUtilisateur());
		reservation.setTopo(topo);
		reservation.setUtilisateur(utilisateur);
		
		ReservationService reservationService = new ReservationService();
		reservationService.create(reservation);
		
		Boolean topoEnAttente = reservationService.isTopoEnAttente(topo, utilisateur);
		System.out.println("topoEnAttente : " + topoEnAttente);

		response.sendRedirect(request.getRequestURI().toString() + "?topoEnAttente=" + topoEnAttente);
	}

}
