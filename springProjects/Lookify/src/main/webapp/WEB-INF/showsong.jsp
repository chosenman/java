<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="wrapper">
<a href="/dashboard" style="float:right">Dashboard</a>

<p>Title: ${song.title}</p>
<p>Artist: ${song.artist}</p>
<p>Rating (1-10): ${song.rating}</p>

<a href="/songs/delete/${song.getId()}">delete</a>
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