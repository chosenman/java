package com.codingdojo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Counter
 */
@WebServlet("/Counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	int counter = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Counter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String counter = (String) session.getAttribute("counter");
		
		if( counter == null ) {
			counter = "0";
			session.setAttribute("counter", counter);
		} else {
			
		}
//		

        
        
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("counterFromSession", counter);
		request.getRequestDispatcher("/WEB-INF/views/counter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       HttpSession session = request.getSession();
	       
	        String counter = (String) session.getAttribute("counter");
	        int counterPlus = Integer.parseInt(counter);
	        counterPlus++;
	        counter = Integer.toString(counterPlus);
//	        counter = "0";
	        
	        session.setAttribute("counter", counter);
 //		this.counter++;
		response.sendRedirect("/ButtonClicker/Counter");
	}

}
