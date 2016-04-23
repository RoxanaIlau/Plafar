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
import model.service.Service;



public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Categorie> categorii = Service.dao.afiseazaCategorii();
		String den = request.getParameter("cuvant");
		
		List<Articol> articole = Service.dao.cautaProdus(den);
		
		request.setAttribute("articole", articole);	
		request.setAttribute("categorii", categorii);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/search.jsp");
		dispatcher.forward(request, response);

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}}


