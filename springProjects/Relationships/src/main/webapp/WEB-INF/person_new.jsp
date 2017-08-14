<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>New Person</h1>

<ul>
	<li><a href="/">Home</a></li>
	
</ul>
		 <form:form method="POST" action="/persons/new" modelAttribute="person">
		 	<form:hidden path="id"/>
		 	
		    <form:label path="firstName">firstName
		    <form:input path="firstName"/></form:label>
		    <span style="color:red"><form:errors path="firstName"/></span>
		    <br/>
		    
		    <form:label path="lastName">lastName
		    <form:input path="lastName"/></form:label>
		    <span style="color:red"><form:errors path="lastName"/></span>
		    <br/>
		    
		    <input type="submit" value="Submit"/>
		</form:form>