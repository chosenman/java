<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo JSP</title>
        <link href="/Pets/style.css" media="all" rel="stylesheet" />
        
    </head>
<body>

    <form method="POST" action="/Pets/cat" style="width:43%; padding:1%;border: 1px solid grey; display:inline-block">
    <h2>Cat form:</h2>
    		Name: <input type="text" name="name"><br/>
    		Breed: <input type="text" name="breed"><br/>
    		Weight: <input type="text" name="weight"><br/>
    		<button type="submit">Submit</button>
    </form>
    
    <form method="POST" action="/Pets/dog" style="width:43%; padding:1%;border: 1px solid grey; display:inline-block">
    <h2>Dog form:</h2>
    		Name: <input type="text" name="name"><br/>
    		Breed: <input type="text" name="breed"><br/>
    		Weight: <input type="text" name="weight"><br/>
    		<button type="submit">Submit</button>
    </form>
    
</body>
</html>