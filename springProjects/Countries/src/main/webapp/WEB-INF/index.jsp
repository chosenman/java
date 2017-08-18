<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <style>
  	b { cursor:pointer; display:block; font-weight:normal; line-height:200%;}
  	b:hover { color:blue}
  	table { display:none;}
  </style>
  
<title>Welcome Page</title>
</head>
<body>

	<b id="one">
	1.  What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, language and language percentage. Your query should arrange the result by language percentage in descending order.
	</b>
	
	<table style="width:50%" id="one">
	<tr style="background:#ccc"><td>Country name</td><td>Language</td><td>Percentage</td></tr>
	<c:forEach var="row" items="${sloveneSpeakingC}">
		<tr>
			<c:forEach var="col" items="${row}">
				<td>${col}</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
	<script>$( "b#one" ).click(function() { $( "table#one" ).toggle(); });</script>
	
	<b id="two">
	2. What query would you run to display the total number of cities for each country? Your query should return the name of the country and the total number of cities. Your query should arrange the result by the number of cities in descending order.
	</b>
	<table style="width:50%" id="two">
	<!-- <tr style="background:#ccc"><td>Country name</td><td>Language</td><td>Percentage</td></tr> -->
	<c:forEach var="row" items="${sedondQuery}">
		<tr>
			<c:forEach var="col" items="${row}">
				<td>${col}</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
		<script>$( "b#two" ).click(function() { $( "table#two" ).toggle(); });</script>
	
</body>
</html>