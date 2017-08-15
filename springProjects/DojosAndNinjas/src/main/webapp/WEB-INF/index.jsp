<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Dojos and Ninjas</h1>

<ul>
	<li><a href="/dojos/new">Add new Dojo</a></li>
	<li><a href="/ninjas/new">Add new Ninja</a></li>
	
</ul>

<table style="width:100%">
	<tr>
		<tr>Name:</td>
	</tr>
	<c:forEach var="dojo" items="${dojos}">
		<tr><td>
		<a href="/dojos/${dojo.id}">
			${dojo.name}
		</a>
		</td></tr>
	</c:forEach>
</table>