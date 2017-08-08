<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<form action="/results" method="POST">
	<p>
		Your name: <input type="text" name="name">
	</p>
	<p>
		Dojo Location: <input type="text" name="location" value="San Jose">
	</p>
	<p>
		Favorite language: <input type="text" name="flang" value="Java Script">
	</p>
	<p>
		Comment(optional):
		<textarea name="comment"></textarea>
	</p>
	<input type="submit" value="submit">
</form>