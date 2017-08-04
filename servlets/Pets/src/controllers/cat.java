package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.*;

/**
 * Servlet implementation class cat
 */
@WebServlet("/cat")
public class cat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String breedCat = request.getParameter("breed");
//		String nameCat = request.getParameter("name");
//		String weightCat = request.getParameter("weight");
		
		Cat myCat = new Cat( request.getParameter("name"), request.getParameter("breed"), request.getParameter("weight") );
		
		request.setAttribute("myCat", myCat);
//		request.setAttribute("nameCat", nameCat);

		
		
		request.getRequestDispatcher("/WEB-INF/views/cat.jsp").forward(request, response);
//		 RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cat.jsp").forward(request, response);
//		 view.forward(request, response);
		
	}

}
