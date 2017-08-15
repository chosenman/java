<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<a href="/">Home</a>
<h1>${dojo.name}</h1>

<table style="width:100%;">
	<tr style="background:#ccc"><td>First Name</td><td>Last Name</td><td>Age</td></tr>

<c:forEach var="current" items="${ninjas}">
	<c:if test="${dojo.ninjas.contains(current)}">
	<tr><td>${current.firstName}</td><td>${current.lastName}</td><td>${current.age}</td></tr>
	</c:if>

</c:forEach>
</table>