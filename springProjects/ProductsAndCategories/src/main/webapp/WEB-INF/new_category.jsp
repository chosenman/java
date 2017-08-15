<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>New Category</h1>
<ul><li><a href="/">Home</a></li></ul>

		 <form:form method="POST" action="/categories/new" modelAttribute="category">
		 	<form:hidden path="id"/>
		 	
		 	
		    
		    <form:label path="name"> Name: 
		    <form:input path="name"/></form:label>
		    <span style="color:red"><form:errors path="name"/></span>
		    <br/>
		    

		    
		    <input type="submit" value="Submit"/>
		</form:form>