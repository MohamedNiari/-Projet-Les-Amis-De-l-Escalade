package org.couche.webapp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Tododemo
 */
@WebServlet("/Tododemo")
public class Tododemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tododemo() {
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
		// get the TO DO items from the session
		
		HttpSession session = request.getSession();	
		List<String> listItems = (List<String>) session.getAttribute("myToDoList");

		// if the TO DO items doesn't exist, then create a new one
		if (listItems == null) {
			listItems = new ArrayList<String>();
			
		}
		
		// see if there is form data to add
		
		String theItem = request.getParameter("theItem");
		System.out.println(theItem);
		if (theItem != null) {
			listItems.add(theItem);
		}
		
		System.out.println("------------");
		for(String toto : listItems)
			System.out.println(toto);
			
		session.setAttribute("myToDoList", listItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/todo-demo.jsp");
		dispatcher.forward(request, response);
	}

}
