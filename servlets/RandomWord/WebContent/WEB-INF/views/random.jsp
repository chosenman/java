<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Random Word</title>
    <link href="/Pets/style.css" media="all" rel="stylesheet" />
</head>
<body>

    <div style="text-align:center; padding-top:30%;">

        You have generated a word ${counter} times
        <h1>

        			${randomWord}

        </h1>
        <form method="POST" action="/RandomWord/Random">
        			 <button type="submit">Generate!</button>
        </form>
        <hr/>
        ${date}
    </div>

</body>
</html>