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

public class CategorieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String categorie = request.getParameter("id");

		List<Categorie> categorii = Service.dao.afiseazaCategorii();

		// if (categorie != null ){

		List<Articol> articole = Service.dao.afiseazaProdusDupaCategorie(categorie);

		request.setAttribute("articole", articole);
		// }

		request.setAttribute("categorii", categorii);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afiseazaCategorie.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
