package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Articol;
import model.domain.Categorie;
import model.domain.User;
import model.service.Service;


public class ServletHome extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String categorie = request.getParameter("categorie");
		
		List<Categorie> categorii = Service.dao.afiseazaCategorii();
		List<Articol> articole = Service.dao.afiseazaProdusDupaCategorie("0");
	
//		//System.out.println(categorie);
//		if (categorie != null){
//			//List<Articol> articole =Service.dao.afiseazaProdusDupaCategorie("Siropuri");
//			List<Articol> articole =Service.dao.afiseazaProdusDupaCategorie(categorie);
//			
//			request.setAttribute("articole", articole);
//			
//		//List<Articol> articole = Service.dao.afiseazaProdusDupaCategorie("Ceaiuri");
//		request.setAttribute("articole", articole);
//		
//		}
		
		request.setAttribute("categorii", categorii);
		request.setAttribute("articole", articole);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afiseaza.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
