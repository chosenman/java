<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<a href="/">Home</a>
<h1>Product Name: ${product.name}</h1>
<p>Description: ${product.description}</p>
<p>Price: ${product.price}</p>

<p>
<h2>Categories:</h2>

<ul>
	<c:forEach var="item" items="${product.categories}">
		<li>${item.name}</li>
	</c:forEach>
</ul>

<hr/>
<h2>Add new category:</h2>
<form action="/products/newCategory" method="POST">
	<input type="hidden" name="product_id" value="${product.id}">
	<select name="category_id">
		<c:forEach var="current" items="${categories}">
			<c:if test="${!product.categories.contains(current)}">
				<option value="${current.id}" > ${current.name}</option>
			</c:if>
		<%-- 	${current.name}<br> --%>
		</c:forEach>
	</select>
	<input type="submit"  value="add"/>
</form>