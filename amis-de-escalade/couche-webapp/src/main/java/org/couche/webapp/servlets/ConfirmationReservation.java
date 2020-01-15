package org.couche.webapp.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ConfirmationReservation
 */
@WebServlet("/ConfirmationReservation")
public class ConfirmationReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupération de la réserve
		ReservationService reservationService = new ReservationService();
		String reservationId = request.getParameter("reservationId");
		Reservation reservation = reservationService.findById(Long.parseLong(reservationId));
		
		// Récupération de l'utilisateur connecté
		HttpSession session = request.getSession(false);
		String adresseMail = (String) session.getAttribute("adresseMail");
		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = utilisateurService.findByEmail(adresseMail);

		// Mise à jour de la table réservation
		if(request.getParameter("accepter") != null) {			
		
			TopoService topoService = new TopoService();
			String topoId = request.getParameter("topoId");
			Topo topo = topoService.findById(Long.parseLong(topoId));
			topo.setDisponible(false);	

			reservation.setAccepter(true);
			reservation.setTopo(topo);
			reservationService.merge(reservation);				
			
		} 
		// Suppression de la réservation dans la BDD
		else if (request.getParameter("refuser") != null) {
			reservationService.delete(reservation);
			
		}
		
		// Mise à jour du nombre de réservation en attente
		List<Reservation> reservations = reservationService.listeReservationEnAttente(utilisateur);			
		Integer nombreReservation = reservations.size();	
		
		// Envoi du nouveau nombre de réservation	
		session.setAttribute("nombreReservation", nombreReservation);		
		
		response.sendRedirect(request.getRequestURI().substring(0,request.getRequestURI().lastIndexOf("/")) + "/MesTopos");
		

	}

}
