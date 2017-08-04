<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Button clicker</title>
    <link href="/Pets/style.css" media="all" rel="stylesheet" />
</head>
<body>

    <div style="text-align:center;">
        <form method="POST" action="/ButtonClicker/Counter">
        			 <button type="submit">Click me!</button>
        </form>
        You have clicked this button ${counterFromSession} times
    </div>

</body>
</html>