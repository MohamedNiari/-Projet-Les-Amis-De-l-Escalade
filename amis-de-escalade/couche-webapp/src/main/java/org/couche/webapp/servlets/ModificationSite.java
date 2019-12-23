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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String nomSite = request.getParameter("nomSite");
		String lieuSite = request.getParameter("lieuSite");
		String hauteurSite = request.getParameter("hauteurSite");
		String descriptionSite = request.getParameter("descriptionSite");
		String nombreSecteurs = request.getParameter("nombreSecteurs");
		String typeRoche = request.getParameter("typeRoche");
		Boolean official = false;
		Integer hauteurSiteInt = 0;
		Long siteId;
		System.out.println(descriptionSite);

		TypeRocher typeRocher = TypeRocher.valueOf(typeRoche);

		try {
			hauteurSiteInt = Integer.parseInt(hauteurSite.trim());
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException: " + e.getMessage());
		}
		
		SiteService siteService = new SiteService();
		siteId = siteService.createSite(nomSite, lieuSite, hauteurSiteInt, official, descriptionSite, typeRocher);
		
		// Récupération du site depuis la BDD
		Site site = siteService.findById(siteId);
		
		// Création des secteurs à vide
		SecteurService secteurService = new SecteurService();
		
		for(int i = 0; i < Long.parseLong(nombreSecteurs); i++) {
			
			secteurService.createSecteur("Veuillez donnez un nom au secteur", i + 1, "Veuillez entrez une description", site);			
		}

		// Chargement du site dans la request
		request.setAttribute("THE_SITE", site);

		// Chargement des images du site
		Collection<String> urlImages = site.getUrlImages();
		request.setAttribute("IMAGE_LIST", urlImages);

		// Récupération des secteurs du site
	
		List<Secteur> secteurs = secteurService.findBySite(siteId);

		// Chargement des secteurs du site
		request.setAttribute("SECTEUR_LIST", secteurs);

		// Récupération des voies
		VoieService voieService = new VoieService();
		List<Voie> voies = voieService.findAll();

		request.setAttribute("VOIE_LIST", voies);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/modifier-sites.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
