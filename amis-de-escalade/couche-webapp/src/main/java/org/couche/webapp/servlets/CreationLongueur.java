package org.couche.webapp.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.couche.business.services.LongueurService;
import org.couche.business.services.SecteurService;
import org.couche.business.services.SiteService;
import org.couche.business.services.VoieService;
import org.couche.model.entities.Longueur;
import org.couche.model.entities.Secteur;
import org.couche.model.entities.Site;
import org.couche.model.entities.Voie;
import org.json.JSONObject;

/**
 * Servlet implementation class creation des voies
 */
@WebServlet("/CreationLongueur")
public class CreationLongueur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationLongueur() {
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

		String siteId = request.getParameter("siteId");
		System.out.println("siteId : " + siteId);

		// Récupération du site depuis la BDD
		SiteService siteService = new SiteService();
		Site site = siteService.findById(Long.parseLong(siteId));

		// Récupération des secteurs du site
		SecteurService secteurService = new SecteurService();
		List<Secteur> secteurs = secteurService.findBySite(Long.parseLong(siteId));
		VoieService voieService = new VoieService();
		LongueurService longueurService = new LongueurService();

		int nombreSecteurs = secteurs.size();

		// Update des longueurs
		for (int i = 0; i < nombreSecteurs; i++) {

			List<Voie> voies = secteurs.get(i).getVoies();
			int nombreVoies = voies.size();			

			for (int j = 0; j < nombreVoies; j++) {
				
				List<Longueur> longueurs = voies.get(j).getLongueurs();
				int nombreLongueurs = longueurs.size();
				
				for (int n = 0; n < nombreLongueurs; n++) {

					Integer mesure = Integer.parseInt(request.getParameter(
							"mesureSecteurNum" + (i + 1) + "VoieNum" + (j + 1) + "longueurNum" + (n + 1)));
					String cotation = request.getParameter(
							"cotationSecteurNum" + (i + 1) + "VoieNum" + (j + 1) + "longueurNum" + (n + 1));
					Boolean equiperSpits = Boolean.parseBoolean(request.getParameter(
							"spitsSecteurNum" + (i + 1) + "VoieNum" + (j + 1) + "longueurNum" + (n + 1)));
					
					longueurs.get(n).setMesure(mesure);
					longueurs.get(n).setCotation(cotation);
					longueurs.get(n).setEquiperSpits(equiperSpits);
					
					longueurService.update(longueurs.get(n));

				}

			}

		}
		
		request.setAttribute("siteId", siteId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DetailsDesSites");
		dispatcher.forward(request, response);

	}

}
