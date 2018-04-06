package com.ecetech.bti3.projetIT.scpi.control;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecetech.bti3.projetIT.scpi.dao.*;
import com.ecetech.bti3.projetIT.scpi.beans.*;

/**
 * Servlet implementation class ControleurPrincipal
 */
@WebServlet("/controleur")
public class ControleurPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControleurPrincipal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "Accueil.jsp";
		String action = request.getParameter("action");
		switch(action)
		{
		case "auth" : // test de connection
			forward = authentifier(request);
			break;
		default : 
			action="index.jsp";
			break;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);
	}
	
	private String authentifier(HttpServletRequest request) {
        String forward;
        String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		CompteUtilisateurDAO c = new CompteUtilisateurDAO();
		CompteUtilisateur nUser = null;
		try {
			nUser = c.getCompteByLogin(login, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (nUser != null) {
            forward = "Accueil.jsp";
            HttpSession session = request.getSession();
//            if (nUser.isAdmin()) {  // methode à définir
//                session.setAttribute("role", "admin");
//            } else {
//                session.setAttribute("role", "user");
//            }
        } else {
            forward = "Error.jsp";
   //         request.setAttribute("erreur", ressource.getString("auth.erreur"));
        }
        return forward;
    }

}
