<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>New Product</h1>
<ul><li><a href="/">Home</a></li></ul>

		 <form:form method="POST" action="/products/new" modelAttribute="product">
		 	<form:hidden path="id"/>
		 	
		 	
<%-- 		    <form:label path="dojo">Dojos: 
		    <form:select path="dojo"  >
		        <form:options items="${dojos}" itemValue="id"  itemLabel="name" />
			</form:select>
		    </form:label>
		    <span style="color:red"><form:errors path="dojo"/></span>
		    <br/> --%>
		    
		    <form:label path="name">Name: 
		    <form:input path="name"/></form:label>
		    <span style="color:red"><form:errors path="name"/></span>
		    <br/>
		    
		    <form:label path="description">Description: 
		    <form:input path="description"/></form:label>
		    <span style="color:red"><form:errors path="description"/></span>
		    <br/>
		    
		    <form:label path="price">price
		    <form:input path="price"/></form:label>
		    <span style="color:red"><form:errors path="price"/></span>
		    <br/>
		    
		    <input type="submit" value="Submit"/>
		</form:form>