package com.codingdojo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String userName = request.getParameter("name");
		String firstName = "Unknown fn";
		String lastName = "unknown last";
		String flang = "Unknown lang";
		String hometown = "unknown hometown";
		
		 firstName = request.getParameter("firstName");
		 lastName = request.getParameter("lastName");
		 flang = request.getParameter("flang");
		 hometown = request.getParameter("hometown");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<h1>Welcome, " + firstName + " " + lastName + "</h1>");
		out.append("<h2>YOur favorite language is: " + flang +"</h2>");
		out.append("<h2>YOur hometown is: " + hometown +"</h2>");
		// http://localhost:8080/Setup/Home?firstName=Yarik&lastName=Kalytiuk&flang=Java%20Script&hometown=Kiev
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
