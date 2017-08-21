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
<body style="width:90%; margin:0 auto">

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
    
 <table style="width:100%"><tr><td valign="top" style="width:50%">
    <!-- EVENTS DETAILS -->
    <p class="desk"> <b>Host:</b> <span style="color:blue;">${currentEvent.host.email}</span> </p>
    <p  class="desk"> <b>Date:</b> <span>${currentEvent.eventDate}</span> </p>
    <p  class="desk"> <b>Location:</b> <span>${currentEvent.location}, ${currentEvent.state}</span> </p>
    <p  class="desk"> <b>People who are attending this event:</b> <span>${currentEvent.users.size()}</span> </p>
    
    <!-- here goes table with users and their location -->
    <table style="width:90%">
    <tr style="background:#ccc"><td>Name</td><td>Location</td></tr>
    <c:forEach var="user" items="${currentEvent.users}">
    <tr>
    		<td>${user.email}</td>
    		<td>${user.location}</td>
    	</tr>
    </c:forEach>
    </table>
    <!-- END EVENTS DETAILS -->


</td><td valign="top">
	<h2>Message Wall</h2>
   <div style="border:1px solid black; width:100%;height:150px; overflow-y:scroll; padding:0px">
    <div style="padding:15px">
	    	<c:forEach var="row" items="${messages}">
	   		<p><b>${row.author.email}: </b>${row.message_text}</p>
	   	</c:forEach> 
   	</div>
   </div>
	<!-- ADD NEW Message  -->
	<h2>Add Message</h2>
   <form:form method="POST" action="/message/new" modelAttribute="message_model">
    
 		<input type="hidden" name="event_id" value="${event_id}" />
 		<input type="hidden" name="user_id" value="${user_id}" />
        <p>
            <form:label path="message_text" type="text" >message:</form:label><br>
            <form:textarea path="message_text" style="width:100%" />
        </p>
    
        

        <input type="submit" value="Create"/>
    </form:form>
	<!-- ADD NEW Message  -->

</td></tr></table>
<style>
.desk { width:90%; border-bottom:1px dashed #ccc; }
.desk span { float:right; }
</style>

</body>
</html>