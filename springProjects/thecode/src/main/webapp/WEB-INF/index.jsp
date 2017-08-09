<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>




<h1 style="text-align:center; margin-top:200px;">
	<form action="/code" method="POST">
		<p style="color:red">
			${errors}
		</p>
			What is the code?
		<p>
			<input type="text" name="codeInput" >
		</p>
		<input type="submit" value="Try Code">
	</form>
</h1>