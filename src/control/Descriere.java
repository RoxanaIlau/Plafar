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

public class Descriere extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Categorie> categorii = Service.dao.afiseazaCategorii();
		request.setAttribute("categorii", categorii);
		String product_id = request.getParameter("id");

		Articol  articole = Service.dao.adaugaDescriere(product_id);
		
		request.setAttribute("articol", articole);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/descriere.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
