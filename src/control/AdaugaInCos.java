package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.domain.Articol;
import model.domain.Categorie;
import model.domain.User;
import model.service.Service;

public class AdaugaInCos extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Categorie> categorii = Service.dao.afiseazaCategorii();

		request.setAttribute("categorii", categorii);

		HttpSession sesiune = request.getSession();
		List<Articol> cos = (List<Articol>) sesiune.getAttribute("cos");

		
		
		String action = request.getParameter("action");
		String product_id = request.getParameter("id");

		
		if (action != null) {
			Iterator<Articol> itr = cos.iterator();

			while (itr.hasNext()) {
				Articol item = itr.next();

				Integer p_id = item.getId();

				if (Integer.toString(p_id).equals(product_id)) {
					itr.remove();
					
				
					
					
					//response.sendRedirect("cos");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cos.jsp");
					dispatcher.forward(request, response);
				}
			}

		}

		sesiune.setAttribute("cos", cos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cos.jsp");
		dispatcher.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesiune = request.getSession();

		List<Articol> cos = (List<Articol>) sesiune.getAttribute("cos");
		if (cos == null) {
			cos = new ArrayList<Articol>();
		}

		cos.add(Service.dao.intoarceProdus(request.getParameter("id")));

		sesiune.setAttribute("cos", cos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cos.jsp");
		dispatcher.forward(request, response);

	}

}
