package com.ecetech.bti3.projetIT.scpi.control;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String forward = "index.jsp";
		if(request.getParameter("action") != null)
		{
			String action = request.getParameter("action");
			switch(action)
			{
			case "auth" : // test de connection
				forward = authentifier(request);
				break;
			case "listBien" :
				ArrayList<Bien> allBiens = BienDAO.getAllBiens();
				request.setAttribute("biens", allBiens);
				forward = "admin/pages/gerer_mes_biens.jsp";
				break;
			case "dashboard" :
				forward = "admin/pages/dashboard.jsp";
				break;
			case "bienEnVente" :
				forward = "admin/pages/biens_en_vente.jsp";
				break;
			case "index" :
				forward = "index.jsp";
				break;
			default : 
				forward="index.jsp";
				break;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);
	}
	
	private String authentifier(HttpServletRequest request) {
        String forward = "login.jsp";
        String login = request.getParameter("lg_username");
		String pass = request.getParameter("lg_password");
		CompteUtilisateurDAO c = new CompteUtilisateurDAO();
		CompteUtilisateur nUser = null;
		try {
			nUser = c.getCompteByLogin(login, pass);
//			System.out.println(nUser.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(nUser != null)
//		{
	        if (!(nUser.getLogin().isEmpty())) {
	            forward = "controleur?action=listBien";
	            System.out.println("Bravo tu es connecté");
	            HttpSession session = request.getSession();
	//            if (nUser.isAdmin()) {  // methode à définir
	//                session.setAttribute("role", "admin");
	//            } else {
	//                session.setAttribute("role", "user");
	//            }
	        } else {
	//            forward = "Error.jsp";
	        	forward = "index.jsp";
	        	System.out.println("Couple login/password incorrect");
	   //         request.setAttribute("erreur", ressource.getString("auth.erreur"));
	        }
//		}
        return forward;
    }

}
