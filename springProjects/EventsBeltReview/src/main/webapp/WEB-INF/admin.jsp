<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>


    		




    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <a href="/events">Events</a> 
        <input type="submit" value="Logout!" />
    </form>
    <h1>Admin dashboard</h1>
    
   <table style="width:100%">
   <tr style="background:#ccc"><td>Name</td><td>Email</td><td>Action</td></tr>
    <c:forEach var="u" items="${allUsers}" >
    		<tr>
    			<td> ${u.userlastname} ${u.email}</td><td>${u.username}</td>
    			<td>
				<c:if test="${u.roles.contains(adminRole)}">
					admin
				</c:if>
				<c:if test="${!u.roles.contains(adminRole)}">
					<a href='/admin/delete/${u.id}'>delete</a> |  <a href='/admin/make_admin/${u.id}'>make admin</a>
				</c:if>
			</td>
    		</tr>
    </c:forEach>
    </table>
    
    
</body>
</html>