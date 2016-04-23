package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Categorie;
import model.domain.User;
import model.service.Service;

public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Categorie> categorii = Service.dao.afiseazaCategorii();

		request.setAttribute("categorii", categorii);
		request.setAttribute("mesaj", null);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("user");
		String pass = request.getParameter("password");

		boolean useri = Service.dao.validare(name, pass);

		if (useri != false) {

			HttpSession sesiune = request.getSession();

			User utilizator = new User(name, pass);

			sesiune.setAttribute("user_logged", true);
			sesiune.setAttribute("user_name", utilizator.getUserName());

			response.sendRedirect("home");

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");

			request.setAttribute("mesaj", "User sau parola incorecta.");

			dispatcher.forward(request, response);
		}
	}

}
