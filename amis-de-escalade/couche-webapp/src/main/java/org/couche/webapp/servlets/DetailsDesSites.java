package org.couche.webapp.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.couche.business.services.SiteService;
import org.couche.model.entities.Site;

/**
 * Servlet implementation class ListeDesSites
 */
@WebServlet("/DetailsDesSites")
public class DetailsDesSites extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération de l'id du site depuis la JSP
		String siteId = request.getParameter("siteId");

		// Récupération du site depuis la BDD
		SiteService siteService = new SiteService();
		Site site = siteService.findById(Long.parseLong(siteId));

		// Chargement du site dans la request
		request.setAttribute("THE_SITE", site);

		Collection<String> urlImages = site.getUrlImages();

		// Chargement des images du site
		request.setAttribute("IMAGE_LIST", urlImages);

		// Envoi à la jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/details-sites.jsp");
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
