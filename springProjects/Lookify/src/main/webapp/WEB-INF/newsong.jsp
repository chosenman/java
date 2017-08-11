<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="wrapper">
<a href="/dashboard" style="float:right">Dashboard</a>
<h1>Add new song</h1>


		 <form:form method="POST" action="/songs/new" modelAttribute="song">
		 	<form:hidden path="id"/>
		 	
		    <form:label path="title">title
		    <form:input path="title"/></form:label>
		    <span style="color:red"><form:errors path="title"/></span>
		    <br/>
		    
		    <form:label path="artist">artist
		    <form:input path="artist"/></form:label>
		    <span style="color:red"><form:errors path="artist"/></span>
		    <br/>
		    
		    <form:label path="rating">rating 
		    <form:input path="rating" type="number"/></form:label>
		    <span style="color:red"><form:errors path="rating"/></span>
		    <br/>
		    
		    
		    <input type="submit" value="Submit"/>
		</form:form>



</div>



<style>
	body {
		background:#ccc;
		}
	.wrapper {
		margin:0 auto;
		width:60%;
	}
	.search {
		display:inline;
		float:right;
	}

</style>