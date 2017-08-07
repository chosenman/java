package com.codingdojo.web;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;

/**
 * Servlet implementation class Stopwatch
 */
@WebServlet("/Stopwatch")
public class Stopwatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Timer sessionTimer;
	Timer newTimer = new Timer();
	String whichButton = null;
	String startTime = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stopwatch() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
//		Date today = Calendar.getInstance().getTime(); 
//		Format formatter = new SimpleDateFormat("HH:mm:ss a");
//		String currentTime = formatter.format(today);
//		request.setAttribute("currentTime", currentTime);
		HttpSession session = request.getSession();
		session.setAttribute("newTimer", newTimer);
		
		startTime = newTimer.getstartTime();

		request.setAttribute("startTime", startTime);
		request.setAttribute("newTimer", newTimer);
		request.setAttribute("whichButton", whichButton);
		request.getRequestDispatcher("/WEB-INF/views/stopwatch.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		newTimer.setWhychButton(request.getParameter("action"));
		
		HttpSession session = request.getSession();
		sessionTimer = (Timer) session.getAttribute("newTimer");
			
//			if(newTimer.getWhychButton() == "start" && startTime == "empty") {
//					newTimer.setStartTime();
//			} else if (newTimer.getWhychButton() == "stop" && startTime != "empty") {
//					newTimer.setStopTime();
//			} else if (newTimer.getWhychButton() == "reset" && startTime != "empty") {
//					newTimer.setStopTime();
//					newTimer.setStartTime();
//			} 
//		newTimer.cleanWhichButton();
		
		response.sendRedirect("/Stopwatch/Stopwatch");


	}

}
