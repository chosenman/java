package com.codingdojo.web;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

/**
 * Servlet implementation class Random
 */
@WebServlet("/Random")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Random() {
        super();
        // TODO Auto-generated constructor stub
    }

	static private String randomAccountNumber() {
		char[] alphabet = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();

  		int min = 0;
  		int max = alphabet.length - 1;
         int range = (max - min) + 1;
         String output = "";
         
         for	(int i=0;i<14;i++) {
        	 	int newNumber = (int)(Math.random() * range) + min;
        	 	output += alphabet[newNumber];
         }
         
         return output;
		}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
//		COUNTER HOW MANY TIMES GENERATOR WAS PUSHED
		String counter = (String) session.getAttribute("counter");
		if(counter == null) {
			counter ="0";
			session.setAttribute("counter", counter);
		}
		
//		RENDERING PAGE
		request.setAttribute("counter", counter);
		request.setAttribute("randomWord", (String) session.getAttribute("randomWord"));
		request.setAttribute("date", (String) session.getAttribute("date") );
		request.getRequestDispatcher("/WEB-INF/views/random.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
//		HO MANY CLICKED
		String counter = (String) session.getAttribute("counter");
		counter = Integer.toString( Integer.parseInt(counter)+1 );
		session.setAttribute("counter", counter);
		
//		Random WORD
		String randomWord = (String) session.getAttribute("randomWord");
		randomWord = randomAccountNumber();
		session.setAttribute("randomWord", randomWord);
		
//		DATE
		Date today = Calendar.getInstance().getTime(); 
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = formatter.format(today);
		session.setAttribute("date", date);
		
		response.sendRedirect("/RandomWord/Random");
		
	}

}
