package org.couche.webapp.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.couche.business.services.CommentaireService;
import org.couche.business.services.SiteService;
import org.couche.business.services.UtilisateurService;
import org.couche.model.entities.Commentaire;
import org.couche.model.entities.Site;
import org.couche.model.entities.Utilisateur;

/**
 * Servlet implementation class CommentaireServlet
 */
@WebServlet("/CommentaireServlet")
public class CommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String siteId = request.getParameter("siteId");
		String commentaire = request.getParameter("commentaire");
		
		HttpSession session =request.getSession(false);
		String adresseMail = (String) session.getAttribute("adresseMail");
		
		UtilisateurService utilisateurService = new UtilisateurService();
		Utilisateur utilisateur = utilisateurService.findByEmail(adresseMail);
		
		SiteService siteService = new SiteService();
		Site site = siteService.findById(Long.parseLong(siteId));
		
		CommentaireService commentaireService = new CommentaireService();
		Commentaire commentaireBean = new Commentaire();
		
		// Creation du format date et heure
		LocalDateTime currentDate = LocalDateTime.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy à HH:mm:ss");
		
		// Enregistrement du commentaire dans la BDD
		commentaireBean.setDateDuCommentaire(currentDate.format(formatter));
		commentaireBean.setTexte(commentaire);
		commentaireBean.setSite(site);
		commentaireBean.setUtilisateur(utilisateur);

		commentaireService.create(commentaireBean, utilisateur, site);
			
		request.setAttribute("siteId", siteId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DetailsDesSites");
		dispatcher.forward(request, response);
		
		
		
	}

}
