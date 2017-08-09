<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ... -->
<a style="float:right" href="/languages">
	Back to Dashboard
</a>
<p>Name: <c:out value="${lang.name}"/></p>
<p>Creator: <c:out value="${lang.creator}"/></p>
<p>Current version: <c:out value="${lang.cver}"/></p>