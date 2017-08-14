<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>New Ninja</h1>
<ul><li><a href="/">Home</a></li></ul>

		 <form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
		 	<form:hidden path="id"/>
		 	
		 	
		    <form:label path="dojo">Dojos: 
		    <form:select path="dojo"  >
		        <form:options items="${dojos}" itemValue="id"  itemLabel="name" />
			</form:select>
		    </form:label>
		    <span style="color:red"><form:errors path="dojo"/></span>
		    <br/>
		    
		    <form:label path="firstName">First Name: 
		    <form:input path="firstName"/></form:label>
		    <span style="color:red"><form:errors path="firstName"/></span>
		    <br/>
		    
		    <form:label path="lastName">Last Name: 
		    <form:input path="lastName"/></form:label>
		    <span style="color:red"><form:errors path="lastName"/></span>
		    <br/>
		    
		    <form:label path="age">Age: 
		    <form:input path="age"/></form:label>
		    <span style="color:red"><form:errors path="age"/></span>
		    <br/>
		    
		    <input type="submit" value="Submit"/>
		</form:form>