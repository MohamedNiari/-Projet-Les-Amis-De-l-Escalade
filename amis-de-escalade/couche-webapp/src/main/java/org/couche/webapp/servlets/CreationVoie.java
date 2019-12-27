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
import org.json.JSONObject;

/**
 * Servlet implementation class creation des voies
 */
@WebServlet("/CreationVoie")
public class CreationVoie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationVoie() {
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
		JSONObject jObj = new JSONObject(request.getParameter("voiesData"));

		SecteurService secteurService = new SecteurService();
		List<Secteur> secteurs = secteurService.findBySite(Long.parseLong(siteId));
		VoieService voieService = new VoieService();

		int nombreSecteurs = secteurs.size();

		// Update des voies
		for (int i = 0; i < nombreSecteurs; i++) {

			List<Voie> voies = secteurs.get(i).getVoies();
			int nombreVoies = voies.size();

			for (int j = 0; j < nombreVoies; j++) {
				System.out.println("*************************************");
				System.out.println("secteur : " + secteurs.get(i).getNom());
				System.out.println("nombreVoies : " + nombreVoies);
				voies.get(j).setNombreLongueurs(jObj.getInt(("secteurNum" + (i + 1) + "nombrelongueurVoieNum" + (j+1))));
				voieService.update(voies.get(j));

			}

		}

	}

}
