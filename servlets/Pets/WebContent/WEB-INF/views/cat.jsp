<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Cat Page</title>
    <link href="/Pets/style.css" media="all" rel="stylesheet" />
</head>
<body>
cat response
    <p>
        ${nameCat}
        
    </p>
    <p>
    		<c:out value="${test}"></c:out>
    	</p>
</body>
</html>