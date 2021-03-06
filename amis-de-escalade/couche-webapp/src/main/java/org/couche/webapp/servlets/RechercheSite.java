package org.couche.webapp.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.couche.business.services.SiteService;
import org.couche.model.entities.Site;
import org.couche.model.entities.TypeRocher;
import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;

/**
 * Servlet implementation class rechercheSite
 */
@WebServlet("/RechercheSite")
public class RechercheSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SiteService siteService = new SiteService();

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

		// Récupération des valeurs depuis la jsp
		String nombreSecteurs = request.getParameter("nombreSecteurs");
		String typeRoche = request.getParameter("typeRoche");
		String lieu = request.getParameter("lieu");


		TypeRocher typeRocher = null;
		if (!typeRoche.trim().equals("Tous")) 
			typeRocher = TypeRocher.valueOf(typeRoche);
		
		Integer numberSecteur = null;
		if (nombreSecteurs.matches("-?\\d+"))
			numberSecteur = Integer.valueOf(nombreSecteurs);


		// Récupération de la liste des sites depuis la la BDD
		List<Site> sites = siteService.searchSite(lieu, typeRocher, numberSecteur);

		// Ajout de sites à la request
		request.setAttribute("SITE_LIST", sites);

		// Récupération de la valeur de l'option
		request.setAttribute("nombreSecteurs", nombreSecteurs);
		request.setAttribute("typeRoche", typeRoche);
		request.setAttribute("lieu", lieu);

		// Envoi à la JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/liste-sites.jsp");
		dispatcher.forward(request, response);

	}

}
