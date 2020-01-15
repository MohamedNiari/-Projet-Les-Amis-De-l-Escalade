package org.couche.webapp.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.couche.business.services.ReservationService;
import org.couche.business.services.SiteService;
import org.couche.business.services.TopoService;
import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Reservation;
import org.couche.model.entities.Site;
import org.couche.model.entities.Topo;
import org.couche.model.entities.Utilisateur;

/**
 * Servlet implementation class CreerTopos
 */
@WebServlet("/CreerTopos")
public class CreerTopos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreerTopos() {
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

		SiteService siteService = new SiteService();
		List<Site> sites = siteService.findByUser(utilisateur);

		request.setAttribute("sites", sites);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/creer-topos.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String[] listeSites = request.getParameterValues("listeSites");
		String nomTopo = request.getParameter("nomTopo");
		String lieuTopo = request.getParameter("lieuTopo");
		String descriptionTopo = request.getParameter("descriptionTopo");
		
	
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		
		Topo topo = new Topo();
		TopoService topoService = new TopoService();
		
		topo.setDateParution(currentDate.format(formatter));
		topo.setDescription(descriptionTopo);
		topo.setDisponible(false);
		topo.setLieu(lieuTopo);
		topo.setNom(nomTopo);	

		
		HttpSession session = request.getSession(false);
		String adresseMail = (String) session.getAttribute("adresseMail");

		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = utilisateurService.findByEmail(adresseMail);
		topo.setUtilisateur(utilisateur);		
		
		SiteService siteService = new SiteService();
		
		for(String nomSite : listeSites) {			
			Site site = siteService.findByName(nomSite);
			topo.addSite(site);	
		}		

		topoService.merge(topo);
				
		response.sendRedirect(request.getContextPath() + "/MesTopos");

	}

}
