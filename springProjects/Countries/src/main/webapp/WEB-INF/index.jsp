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
	<p style="color:green">click to open</p>

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
	
	<b id="t3">
	3. What query would you run to get all languages in each country with a percentage greater than 89%? Your query should arrange the result by percentage in descending order.
	</b>
	<table style="width:50%" id="t3">
	<!-- <tr style="background:#ccc"><td>Country name</td><td>Language</td><td>Percentage</td></tr> -->
	<c:forEach var="row" items="${q3}">
		<tr>
			<c:forEach var="col" items="${row}">
				<td>${col}</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
		<script>$( "b#t3" ).click(function() { $( "table#t3" ).toggle(); });</script>
	
	<b id="t4">
	3.What query would you run to get all the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order.
	</b>
	<table style="width:50%" id="t4">
	<!-- <tr style="background:#ccc"><td>Country name</td><td>Language</td><td>Percentage</td></tr> -->
	<c:forEach var="row" items="${q4}">
		<tr>
			<c:forEach var="col" items="${row}">
				<td>${col}</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
		<script>$( "b#t4" ).click(function() { $( "table#t4" ).toggle(); });</script>
	
	<b id="t5">
	5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
	</b>
	<table style="width:50%" id="t5">
	<!-- <tr style="background:#ccc"><td>Country name</td><td>Language</td><td>Percentage</td></tr> -->
	<c:forEach var="row" items="${q5}">
		<tr>
			<c:forEach var="col" items="${row}">
				<td>${col}</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
		<script>$( "b#t5" ).click(function() { $( "table#t5" ).toggle(); });</script>
	
	<b id="t6">
	6. What query would you run to get countries with only Constitutional Monarchy with a capital greater than 200 and a life expectancy greater than 75 years?
	</b>
	<table style="width:50%" id="t6">
	<!-- <tr style="background:#ccc"><td>Country name</td><td>Language</td><td>Percentage</td></tr> -->
	<c:forEach var="row" items="${q6}">
		<tr>
			<c:forEach var="col" items="${row}">
				<td>${col}</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
		<script>$( "b#t6" ).click(function() { $( "table#t6" ).toggle(); });</script>
	
	<b id="t7">
	7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? The query should return the Country Name, City Name, District and Population.
	</b>
	<table style="width:50%" id="t7">
	<!-- <tr style="background:#ccc"><td>Country name</td><td>Language</td><td>Percentage</td></tr> -->
	<c:forEach var="row" items="${q7}">
		<tr>
			<c:forEach var="col" items="${row}">
				<td>${col}</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
		<script>$( "b#t7" ).click(function() { $( "table#t7" ).toggle(); });</script>
	
	<b id="t8">
	8. What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. Also, the query should arrange the result by the number of countries in descending order.
	</b>
	<table style="width:50%" id="t8">
	<!-- <tr style="background:#ccc"><td>Country name</td><td>Language</td><td>Percentage</td></tr> -->
	<c:forEach var="row" items="${q8}">
		<tr>
			<c:forEach var="col" items="${row}">
				<td>${col}</td>
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
		<script>$( "b#t8" ).click(function() { $( "table#t8" ).toggle(); });</script>
	
</body>
</html>