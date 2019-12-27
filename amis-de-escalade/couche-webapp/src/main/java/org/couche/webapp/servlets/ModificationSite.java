package org.couche.webapp.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.couche.business.services.SecteurService;
import org.couche.business.services.SiteService;
import org.couche.business.services.VoieService;
import org.couche.model.entities.Secteur;
import org.couche.model.entities.Site;
import org.couche.model.entities.TypeRocher;
import org.couche.model.entities.Voie;

/**
 * Servlet implementation class rechercheSite
 */
@WebServlet("/ModificationSite")
@MultipartConfig
public class ModificationSite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificationSite() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String nombreVoies = request.getParameter("nombreVoies").trim();
		String secteurId = request.getParameter("secteurId").trim();
		Integer nombreVoiesInt = 0;
		
		try {
			nombreVoiesInt = Integer.parseInt(nombreVoies);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException: " + e.getMessage());
		}
		
		SecteurService secteurService = new SecteurService();
		Secteur secteur = secteurService.findById(Long.parseLong(secteurId));
		
		// Enregistremenet des voies en BDD
		VoieService voieService = new VoieService();
		
		for(int i = 0; i < nombreVoiesInt; i++) {
			
			voieService.createVoie(1, i + 1, secteur);			
		}
		
		// Chargement des secteurs du site
		List<Secteur> secteurs = secteurService.findBySite(1L);
		
		// Envoie des secteurs en ajax
		request.setAttribute("SECTEUR_LIST", secteurs);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(secteurs);			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
