<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>

    <c:if test="${logoutMessage != null}">
    		<span style="color:green">
        <c:out value="${logoutMessage}"></c:out>
        </span>
    </c:if>

    <c:if test="${errorMessage != null}">
	    	<span style="color:red">
	        <c:out value="${errorMessage}"></c:out>
	    </span>
    </c:if>
    
	<!-- LOGIN LOGOUT -->
	    <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        
	        <a href="/events">Events</a> 
	    <c:if test="${isAdmin}">
	    		<a href="/admin">Admin Dashboard</a>
	    </c:if>
	        
	        <input type="submit" value="Logout!"  style="float:right;"/>
	    </form>
	<!-- LOGIN LOGOUT -->

    <h1><c:out value="${currentEvent.name}"></c:out></h1>
    
 <table><tr><td valign="top">
    <!-- EVENTS DETAILS -->
    <p> <b>Host:</b> ${currentEvent.host.email} </p>
    <p> <b>Date:</b> ${currentEvent.eventDate} </p>
    <p> <b>Location:</b> ${currentEvent.location}, ${currentEvent.state} </p>
    <p> <b>People who are attending this event:</b> ${currentEvent.users.size()} </p>
    
    <- here goes table with users and their location ->
    <!-- END EVENTS DETAILS -->


</td><td valign="top">
    <- here goes table with messages ->
	<!-- ADD NEW EVENT  -->
	<h2>Add Message</h2>
   <form:form method="POST" action="/message/new" modelAttribute="message">
    
 
        <p>
            <form:label path="message" type="text">message:</form:label>
            <form:input path="message"/>
        </p>
    
        

        <input type="submit" value="Create"/>
    </form:form>
	<!-- ADD NEW EVENT  -->

</td></tr></table>

</body>
</html>