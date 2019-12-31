package org.couche.webapp.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.couche.business.services.LongueurService;
import org.couche.business.services.SecteurService;
import org.couche.business.services.VoieService;
import org.couche.model.entities.Longueur;
import org.couche.model.entities.Secteur;
import org.couche.model.entities.Voie;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String siteId = request.getParameter("siteId");
		JSONObject jObj = new JSONObject(request.getParameter("voiesData"));

		SecteurService secteurService = new SecteurService();
		List<Secteur> secteurs = secteurService.findBySite(Long.parseLong(siteId));
		VoieService voieService = new VoieService();
		LongueurService longueurService = new LongueurService();

		int nombreSecteurs = secteurs.size();

		// Update des voies
		for (int i = 0; i < nombreSecteurs; i++) {

			List<Voie> voies = secteurs.get(i).getVoies();
			int nombreVoies = voies.size();
			int nombreLongueurs = 0;

			for (int j = 0; j < nombreVoies; j++) {
				nombreLongueurs = jObj.getInt(("secteurNum" + (i + 1) + "nombrelongueurVoieNum" + (j + 1)));
				voies.get(j).setNombreLongueurs(nombreLongueurs);
				voieService.update(voies.get(j));

				// Création des longueurs
				for (int n = 0; n < nombreLongueurs; n++) {

					Longueur longueur = new Longueur();
					longueur.setCotation("");
					longueur.setEquiperSpits(false);
					longueur.setMesure(0);
					longueur.setNumeroLongueur(n + 1);
					longueur.setVoie(voies.get(j));

					longueurService.create(longueur);
				}

			}

		}

		//request.setAttribute("siteId", siteId);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/ModificationSite");
		//dispatcher.forward(request, response);

		// HttpSession session = request.getSession(false);
		// session.setAttribute("siteId", siteId);
		// response.sendRedirect("/SiteEscalade/ModificationSite");
		
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
	    
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.add("url", new Gson().toJsonTree(request.getRequestURL().substring(0, request.getRequestURL().lastIndexOf("/"))+"/ModificationSite?siteId=" + siteId));
        
	    response.getWriter().write(jsonResponse.toString()); 

	}

}
