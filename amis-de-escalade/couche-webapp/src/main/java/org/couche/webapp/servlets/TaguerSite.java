package org.couche.webapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.couche.business.services.SiteService;
import org.couche.model.entities.Site;

/**
 * Servlet implementation class TaguerSite
 */
@WebServlet("/TaguerSite")
public class TaguerSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaguerSite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taguerOfficiel = request.getParameter("taguerOfficiel");
		String siteId = request.getParameter("siteId");
		SiteService siteService = new SiteService();
		
		Site site = siteService.findById(Long.parseLong(siteId));
		
		if(taguerOfficiel.equals("Oui")) {
			site.setTaguerOfficiel(true);
		}
		else
		{
			site.setTaguerOfficiel(false);
		}
		
		siteService.update(site);
		
		request.setAttribute("siteId", siteId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DetailsDesSites");
		dispatcher.forward(request, response);

	}

}
