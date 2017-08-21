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
	        <a href="/events">Back to Events</a>
	    <c:if test="${isAdmin}">
	    		<a href="/admin">Admin Dashboard</a>
	    </c:if>
	        
	        <input type="submit" value="Logout!"  style="float:right;"/>
	    </form>
	<!-- LOGIN LOGOUT -->

    <h1>Welcome, <c:out value="${currentUser.email}"></c:out> (${currentUser.id})</h1>
    
    <p>
    Here are some of the events in your state:
    </p>
    
    
	<!-- ADD NEW EVENT  -->
	<h2>Edit Event:</h2>
   <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
    
 
        <p>
            <form:label path="name" type="text">Name:</form:label>
            <form:input path="name"/>
        </p>
    
        <p>
	        <form:label path="eventDate">Event Date:
			    <input type="date" name="myDate" value="${dateString}"/>
			</form:label>
		    <span style="color:red"><form:errors path="eventDate"/></span>
            
        </p>
    
        <p>
            <form:label path="location" >Location:</form:label>
            <form:input path="location" />
            
            <form:select path="state" width="20px" placeholder="state">
            		<c:forEach var="st" items="${states}">
            			<c:if test="${st == event.state}">
            				<option value="${st}" selected>${st}</option>
            			</c:if>
            			<c:if test="${st != event.state}">
            				<option value="${st}">${st}</option>
            			</c:if>
            		</c:forEach>
            </form:select>
        </p>
        

        <input type="submit" value="Sqve"/>
    </form:form>
	<!-- ADD NEW EVENT  -->

</body>
</html>