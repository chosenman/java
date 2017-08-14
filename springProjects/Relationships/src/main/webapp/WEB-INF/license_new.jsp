<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>New License</h1>
<ul><li><a href="/">Home</a></li></ul>

		 <form:form method="POST" action="/licenses/new" modelAttribute="license">
		 	<form:hidden path="id"/>
		 	
		    <%-- hidden field value="Hello JavaInterviewPoint" --%> 
		    <form:label path="number">
		    <form:hidden  path="number"  /></form:label>
		    <span style="color:red"><form:errors path="number"/></span>
		    <%-- HIDDEN FIELD --%>
		 	
		    <form:label path="person">Person: 
		    <form:select path="person"  >
		    
			<%-- itemValue="firstName" --%>
			
		        <form:options items="${allpersons}" itemValue="id"  itemLabel="firstName" />
			</form:select>
		    </form:label>
		    <span style="color:red"><form:errors path="person"/></span>
		    <br/>
		    
		    <form:label path="state">State: 
		    <form:input path="state"/></form:label>
		    <span style="color:red"><form:errors path="state"/></span>
		    <br/>
		    
		    Expiration date: <%-- <form:label path="expiration_date">  
		    <form:input path="expiration_date" type="date"/></form:label> --%>
		    <input type="date" name="myDate" />
		    <span style="color:red"><form:errors path="expiration_date"/></span>
		    <br/>
		    
		    
		    <input type="submit" value="Submit"/>
		</form:form>