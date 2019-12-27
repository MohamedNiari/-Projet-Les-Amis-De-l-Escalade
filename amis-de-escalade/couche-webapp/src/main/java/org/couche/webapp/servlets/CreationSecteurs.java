package org.couche.webapp.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class rechercheSite
 */
@WebServlet("/CreationSecteurs")
public class CreationSecteurs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationSecteurs() {
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

		SecteurService secteurService = new SecteurService();
		List<Secteur> secteurs = secteurService.findBySite(Long.parseLong(siteId));
		VoieService voieService = new VoieService();

		// Récupération du json String
		JSONObject jObj = new JSONObject(request.getParameter("secteursData"));
		
		int nombreSecteurs = secteurs.size();
		List<Integer> totalVoies = new ArrayList<Integer>();

		// Update des secteurs et création des voies à vide
		for (int i = 0; i < nombreSecteurs; i++) {

			secteurs.get(i).setNom(jObj.get("nomSecteurNum" + (i + 1)).toString());
			secteurs.get(i).setDescription(jObj.get("descriptionSecteurNum" + (i + 1)).toString());
			secteurService.update(secteurs.get(i));

			int nombreVoie = jObj.getInt("nombreVoiesSecteurNum" + (i + 1));
			totalVoies.add(nombreVoie);

			for (int j = 0; j < nombreVoie; j++)
				voieService.createVoie(0, (j + 1), secteurs.get(i));

		}
		
		// Envoi des données en json
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
	    
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.add("nombreSecteurs", new Gson().toJsonTree(nombreSecteurs));
        jsonResponse.add("totalVoies", new Gson().toJsonTree(totalVoies));  
        jsonResponse.add("siteId", new Gson().toJsonTree(siteId));
        
	    response.getWriter().write(jsonResponse.toString()); 

	}

}
