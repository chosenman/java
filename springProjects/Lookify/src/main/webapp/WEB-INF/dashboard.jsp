<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="wrapper">
	<a href="/songs/new">Add New</a> | 
	<a href="/songs/topTen">Top 10 Songs</a> | 
	<a href="/dashboard" >Dashboard</a>
	
	<form class="search" method="POST" action="/songs/artist/search">
			<input type="text" name="searchQuery">
			<input type="submit" value="Search Artists">
	</form>
	
	<!--  -->
	<c:if test="${name != null }">
		<h2>Songs by artist "${name}"</h2>
	</c:if>
		<table style="width:100%; line-height:140%;">
			<tr style="background:#999"><td>id</td><td>Name	</td><td>rating</td><td>actions</td></tr>
			<c:forEach var="song" items="${songs}" varStatus="loop" >
				<tr >
				<td>${loop.index + 1} </td>
				<td><a href="/songs/${song.getId()}">${song.title}</a>
					(${song.artist})	</td>
				<td>${song.rating}</td>
				<td><a href="/songs/delete/${song.getId()}">delete</a></td></tr>
			</c:forEach>
		</table>
</div>







<style>
	body {
		background:#ccc;
		}
	.wrapper {
		margin:0 auto;
		width:80%;
	}
	.search {
		display:inline;
		float:right;
	}

</style>