package org.couche.webapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.couche.business.services.SiteService;
import org.couche.model.entities.Site;
import org.couche.model.entities.TypeRocher;

/**
 * Servlet implementation class rechercheSite
 */
@WebServlet("/RechercheSite")
public class RechercheSite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheSite() {
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

		String nombreSecteurs = request.getParameter("nombreSecteurs");
		Integer numberSecteur = null;

		if (nombreSecteurs.matches("-?\\d+")) {
			numberSecteur = Integer.valueOf(nombreSecteurs);

			String lieu = "Privas";
			TypeRocher typeRoche = TypeRocher.Granite;

			// Récupération de la liste des sites depuis la la BDD
			SiteService siteService = new SiteService();
			List<Site> sites = siteService.searchSite(lieu, typeRoche, numberSecteur);

			// Ajout de sites à la request
			request.setAttribute("SITE_LIST", sites);
			
			//Récupération de la valeur de l'option
			request.setAttribute("nombreSecteurs", nombreSecteurs);

			// Envoi à la JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("/liste-sites.jsp");
			dispatcher.forward(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListeDesSites");
			dispatcher.forward(request, response);
		}
	}

}
