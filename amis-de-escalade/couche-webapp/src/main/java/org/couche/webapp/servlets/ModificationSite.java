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
import javax.servlet.http.HttpSession;

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

		// Récupération de l'id du site depuis la JSP
		String siteId = request.getParameter("siteId");

		// Récupération du site depuis la BDD
		SiteService siteService = new SiteService();
		Site site = siteService.findById(Long.parseLong(siteId));
		
		String ancienNomSite = site.getNom();
		
		// Check des noms en doublon
		siteService.validationNomSite(site);
		
		if(!site.getNom().equals(ancienNomSite))
			request.setAttribute("nouveauNomSite", true);

		// Chargement du site dans la request
		request.setAttribute("THE_SITE", site);

		// Chargement des images du site
		Collection<String> urlImages = site.getUrlImages();
		request.setAttribute("IMAGE_LIST", urlImages);

		// Récupération des secteurs du site
		SecteurService secteurService = new SecteurService();
		List<Secteur> secteurs = secteurService.findBySite(Long.parseLong(siteId));

		// Chargement des secteurs du site
		request.setAttribute("SECTEUR_LIST", secteurs);

		// Récupération des voies
		VoieService voieService = new VoieService();
		List<Voie> voies = voieService.findAll();

		request.setAttribute("VOIE_LIST", voies);
		
		// Envoi de l'id du site en cours de modification
		request.setAttribute("siteId", siteId);

		// Envoi à la jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/modifier-sites.jsp");
		dispatcher.forward(request, response);		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);

	}
	

}
