package org.couche.webapp.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.couche.business.services.SiteService;
import org.couche.model.entities.Site;;

/**
 * Servlet implementation class TelechargerImages
 */
@WebServlet("/TelechargerImages")
@MultipartConfig
public class TelechargerImages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240;
	public static final String CHEMIN_FICHIERS = "/img/";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TelechargerImages() {
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

		ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());

		int i = 1;
		try {
			List<FileItem> multifiles = fileUpload.parseRequest(request);
			String siteId = request.getParameter("siteId");
			SiteService serviceSite = new SiteService();

			Site site = serviceSite.findById(Long.parseLong(siteId.toString()));
			List<String> urlImages = site.getUrlImages();

			for (FileItem item : multifiles) {
				item.write(new File(getServletContext().getRealPath(CHEMIN_FICHIERS + site.getNom() + i + ".png")));
				urlImages.add("img/" + site.getNom() + i + ".png");				
				i++;
			}
			
			site.setUrlImages(urlImages);
			serviceSite.update(site);
			
			request.setAttribute("siteId", siteId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ModificationSite");
			dispatcher.forward(request, response);


		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
