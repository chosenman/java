<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<a style="float:right" href="/languages">
	Back to Dashboard
</a>

<form:form method="POST" action="/languages/update/${index}" modelAttribute="lang">
    <form:label path="name">name
    <form:input path="name"/></form:label>
    <span style="color:red"><form:errors path="name"/></span>
    <br/>
    
    <form:label path="creator">Creator
    <form:input path="creator"/></form:label>
    <span style="color:red"><form:errors path="creator"/></span>
    <br/>
    
    <form:label path="cver">Current version
    <form:input path="cver"/></form:label>
    <span style="color:red"><form:errors path="cver"/></span>
    <br/>
    
    
    <input type="submit" value="Submit"/>
</form:form>

<%-- <form action="/languages/update/${index}" method="POST">
	<p>
		Name: 
		<input name="name" value="${lang.name}">
	</p>
	<p>
		Name: 
		<input name="creator" value="${lang.creator}">
	</p>
	<p>
		Name: 
		<input name="cver" value="${lang.cver}">
	</p>
	<input type="submit" value="update">

</form> --%>