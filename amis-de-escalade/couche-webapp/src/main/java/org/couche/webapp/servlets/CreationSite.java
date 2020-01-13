package org.couche.webapp.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.couche.business.services.SecteurService;
import org.couche.business.services.SiteService;
import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Site;
import org.couche.model.entities.TypeRocher;
import org.couche.model.entities.Utilisateur;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class creation de site
 */
@WebServlet("/CreationSite")
@MultipartConfig
public class CreationSite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationSite() {
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

		TypeRocher typeRocher = TypeRocher.valueOf(typeRoche);

		try {
			hauteurSiteInt = Integer.parseInt(hauteurSite.trim());
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException: " + e.getMessage());
		}

		// Création du site
		SiteService siteService = new SiteService();
		siteId = siteService.createSite(nomSite, lieuSite, hauteurSiteInt, official, descriptionSite, typeRocher);

		HttpSession session = request.getSession(false);
		String adresseMail = (String) session.getAttribute("adresseMail");

		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = utilisateurService.findByEmail(adresseMail);

		// Récupération du site depuis la BDD
		Site site = siteService.findById(siteId);
		site.setUtilisateur(utilisateur);
		siteService.update(site);

		// Création des secteurs à vide
		SecteurService secteurService = new SecteurService();

		for (int i = 0; i < Integer.parseInt(nombreSecteurs); i++) {

			secteurService.createSecteur("", i + 1, "", site);
		}

		// Envoi des données en json
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		JsonObject jsonResponse = new JsonObject();
		jsonResponse.add("nombreSecteurs", new Gson().toJsonTree(nombreSecteurs));
		jsonResponse.add("siteId", new Gson().toJsonTree(siteId));

		response.getWriter().write(jsonResponse.toString());

	}

}
