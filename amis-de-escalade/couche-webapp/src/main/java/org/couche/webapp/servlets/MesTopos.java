package org.couche.webapp.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
@WebServlet("/MesTopos")
public class MesTopos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MesTopos() {
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
		
		List<Topo> topos = topoService.findByUser(utilisateur);			
		List<Reservation> reservations = reservationService.listeReservationEnAttente(utilisateur);
		
		// Récupération du nombre de réservation en attente
		Integer nombreReservation = reservations.size();
		
		// Récupération des utilisateurs et topos par réservation
		HashMap<Topo, Utilisateur> mapReservationAttente = new HashMap<Topo, Utilisateur>();		
		for(Reservation reservation : reservations) {
			mapReservationAttente.put(reservation.getTopo(), reservation.getUtilisateur());
			reservation.getId();
		}
		request.setAttribute("nombreReservation", nombreReservation);
		request.setAttribute("mapReservationAttentes", mapReservationAttente);
		request.setAttribute("topos", topos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/mes-topos.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * Mise à jour de la disponibilité d'un Topo
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String topoId = request.getParameter("topoId");

		Boolean disponibilite = false;
		String disponibiliteSite = request.getParameter("disponibiliteSite");
			
		if(disponibiliteSite != null && disponibiliteSite.equals("Oui")) {
			disponibilite = true;
		}
		
		if(disponibiliteSite == null || disponibiliteSite.equals("Non")) {
			disponibilite = false;
		}
				
		TopoService topoService = new TopoService();
		Topo topo = topoService.findById(Long.parseLong(topoId));
		
		topo.setDisponible(disponibilite);
		topoService.update(topo);	
		
		doGet(request,response);
	}

}
