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
	        
	    <c:if test="${isAdmin}">
	    		<a href="/admin">Admin Dashboard</a>
	    </c:if>
	        
	        <input type="submit" value="Logout!"  style="float:right;"/>
	    </form>
	<!-- LOGIN LOGOUT -->

    <h1>Welcome, <c:out value="${currentUser.email}"></c:out> (${currentUser.id})</h1>
    
 
    
    <!-- SHOW EVENTS IN YOUR STATE -->
   <h2>Here are some of the events in your state: </h2>
    <table style="width:100%">
    <tr style="background:#ccc"><td>Name</td><td>Date</td><td>Location</td><td>Host</td><td>Action/ Status</td></tr>
    <c:forEach var="row" items="${allEvents}">
    		<c:if test="${row.getState() == currentUser.state}">
	    		<!-- for OUR STATE -->
	    		<tr><td><a href="/events/${row.id}">${row.name}</a></td>
	    		<td>${row.eventDate}</td><td>${row.location}</td><td>${row.host.email}</td>
	    		<td>
				<c:choose>
				  <c:when test="${row.getHost().getId() == currentUser.id }">
		    		 	<a href="/events/${row.getId()}/edit">edit</a>  |  
		    		 	<a href="/events/${row.getId()}/delete">delete</a>
				  </c:when>
				  <c:when test="${row.users.contains( currentUser ) }">
				    		Joined  
				    		<a href="/events/${row.getId()}/cancel">Cancel</a>		  
				    </c:when>
				  <c:otherwise>
			     	 <c:if test="${row.getHost().getId() != currentUser.id }">
			    		 	<a href="/events/${row.getId()}/join">join</a>
			    		 </c:if>
				  </c:otherwise>
				</c:choose>
	    		 </td></tr>
    		 </c:if>
    </c:forEach>
    </table>
    <!-- SHOW ALL EVENTS -->
    
    <!-- SHOW EVENTS IN Another STATEs -->
       <h2>Here are events in another states: </h2>
    <table style="width:100%">
    <tr style="background:#ccc"><td>Name</td><td>Date</td><td>Location</td><td>Host</td><td>Action/ Status</td></tr>
    <c:forEach var="row" items="${allEvents}">
    		<c:if test="${row.getState() != currentUser.state}">
	    		<!-- for OUR STATE -->
	    		<tr><td><a href="/events/${row.id}">${row.name}</a></td>
	    		<td>${row.eventDate}</td><td>${row.location}</td><td>${row.host.email}</td>
	    		<td>
				<c:choose>
				  <c:when test="${row.getHost().getId() == currentUser.id }">
		    		 	<a href="/events/${row.getId()}/edit">edit</a>  |  
		    		 	<a href="/events/${row.getId()}/delete">delete</a>
				  </c:when>
				  <c:when test="${row.users.contains( currentUser ) }">
				    		Joined  
				    		<a href="/events/${row.getId()}/cancel">Cancel</a>		  
				    </c:when>
				  <c:otherwise>
			     	 <c:if test="${row.getHost().getId() != currentUser.id }">
			    		 	<a href="/events/${row.getId()}/join">join</a>
			    		 </c:if>
				  </c:otherwise>
				</c:choose>
	    		 </td></tr>
    		 </c:if>
    </c:forEach>
    </table>
    <!-- SHOW ALL EVENTS -->
    
	<!-- ADD NEW EVENT  -->
	<h2>Create an Event</h2>
   <form:form method="POST" action="/events/new" modelAttribute="event">
    
 
        <p>
            <form:label path="name" type="text">Name:</form:label>
            <form:input path="name"/>
        </p>
    
        <p>
	        <form:label path="eventDate">Event Date:
			    <input type="date" name="myDate" />
			</form:label>
		    <span style="color:red"><form:errors path="eventDate"/></span>
        </p>
    
        <p>
            <form:label path="location" >Location:</form:label>
            <form:input path="location"/>
            
            <form:select path="state" width="20px" placeholder="state">
            		<c:forEach var="st" items="${states}">
            			<option value="${st}">${st}</option>
            		</c:forEach>
			</form:select>
        </p>
        

        <input type="submit" value="Create"/>
    </form:form>
	<!-- ADD NEW EVENT  -->

</body>
</html>