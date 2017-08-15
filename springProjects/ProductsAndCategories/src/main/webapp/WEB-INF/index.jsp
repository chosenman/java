<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Products and Categories</h1>

<ul>
	<li><a href="/products/new">Add new Product</a></li>
	<li><a href="/categories/new">Add new Category</a></li>
	
</ul>

<table style="width:100%;"><tr><td valign="top">
	<!--  -->
		<h2>Category table</h2>
		<table>
			<tr style="background:#ccc"><td >Name</td></tr>
			<c:forEach items="${allCategories}" var="current">
				<tr><td>
				<a href="/categories/${current.id}">${current.name}</a>
				</td></tr>
			</c:forEach>
		</table>
	<!--  -->
</td><td valign="top">
	<!--  -->
		<h2>Product table</h2>
		<table>
			<tr style="background:#ccc"><td>Name</td><td>Description</td><td>Price</td></tr>
			<c:forEach items="${allProducts}" var="current">
				<tr><td>
				<a href="/products/${current.id}">${current.name}</a>
				</td>
				<td>${current.description}</td><td>${current.price}</td>
				</tr>
			</c:forEach>
		</table>
	<!--  -->
</td></tr></table>