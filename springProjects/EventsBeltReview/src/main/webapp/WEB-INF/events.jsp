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

    <h1>Welcome, <c:out value="${currentUser.email}"></c:out></h1>
    
    <p>
    Here are some of the events in your state:
    </p>
    
    <!-- SHOW ALL EVENTS -->
    <table style="width:100%">
    <tr style="background:#ccc"><td>Name</td><td>Date</td><td>Location</td><td>Host</td><td>Action/ Status</td></tr>
    <c:forEach var="row" items="${allEvents}">
    		<tr><td><a href="/events/${row.id}">${row.name}</a></td>
    		<td>${row.eventDate}</td><td>${row.location}</td><td>${row.host.email}</td><td> - </td></tr>
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
	<option value="AL">Alabama</option><option value="AK">Alaska</option><option value="AZ">Arizona</option>
	<option value="AR">Arkansas</option><option value="CA">California</option><option value="CO">Colorado</option>
	<option value="CT">Connecticut</option><option value="DE">Delaware</option><option value="DC">District Of Columbia</option>
	<option value="FL">Florida</option><option value="GA">Georgia</option><option value="HI">Hawaii</option>
	<option value="ID">Idaho</option><option value="IL">Illinois</option><option value="IN">Indiana</option>
	<option value="IA">Iowa</option><option value="KS">Kansas</option><option value="KY">Kentucky</option>
	<option value="LA">Louisiana</option><option value="ME">Maine</option><option value="MD">Maryland</option>
	<option value="MA">Massachusetts</option><option value="MI">Michigan</option><option value="MN">Minnesota</option>
	<option value="MS">Mississippi</option><option value="MO">Missouri</option><option value="MT">Montana</option>
	<option value="NE">Nebraska</option><option value="NV">Nevada</option><option value="NH">New Hampshire</option>
	<option value="NJ">New Jersey</option><option value="NM">New Mexico</option><option value="NY">New York</option>
	<option value="NC">North Carolina</option><option value="ND">North Dakota</option><option value="OH">Ohio</option>
	<option value="OK">Oklahoma</option><option value="OR">Oregon</option><option value="PA">Pennsylvania</option>
	<option value="RI">Rhode Island</option><option value="SC">South Carolina</option><option value="SD">South Dakota</option>
	<option value="TN">Tennessee</option><option value="TX">Texas</option><option value="UT">Utah</option><option value="VT">Vermont</option>
	<option value="VA">Virginia</option><option value="WA">Washington</option><option value="WV">West Virginia</option>
	<option value="WI">Wisconsin</option><option value="WY">Wyoming</option>
            </form:select>
        </p>
        

        <input type="submit" value="Create"/>
    </form:form>
	<!-- ADD NEW EVENT  -->

</body>
</html>