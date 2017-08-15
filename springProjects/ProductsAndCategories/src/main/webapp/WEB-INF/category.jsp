<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<a href="/">Home</a>
<h1>Category name: ${category.name}</h1>

<h2>Products in this category:</h2>
<ul>
	<c:forEach var="item" items="${category.products}">
		<li>${item.name}</li>
	</c:forEach>
</ul>


<hr/>
<h2>Add new product:</h2>
<form action="/categories/newCategory" method="POST">
	<input type="hidden" name="category_id" value="${category.id}">
	<select name="product_id">
		<c:forEach var="current" items="${products}">
			<c:if test="${!category.products.contains(current)}">
				<option value="${current.id}" > ${current.name}</option>
			</c:if>
		<%-- 	${current.name}<br> --%>
		</c:forEach>
	</select>
	<input type="submit"  value="add"/>
</form>