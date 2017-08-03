<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo JSP</title>
        <link href="/Checkerboard/style.css" media="all" rel="stylesheet" />
        
    </head>
<body>

    <!-- getting the value for the name parameter -->
    <% 
   
    		String height = request.getParameter("height"); 
    		String width = request.getParameter("width"); 
    
    %>
    <!-- displaying the value -->
    <h1><%= width %></h1>
    <h1><%= height %></h1>

    <!-- this is a declaration tag for methods -->
   <%   for(int y = 1; y<= Integer.parseInt(height); y++ ) {  %>
   <% if(y%2 == 0) { %> 
   		<div class="row shiftsequance"> 
   <% } else { %> 
   		<div class="row"> 
   <% } %>
		   <%   for(int i = 1; i<= Integer.parseInt(width); i++ ) {  %>
		   			<% if(i%2 == 0) { %>
		   					<div class="square white"></div>
		   			<% } else { %>
	    						<div class="square"></div>
		   			<% } %>
		   <%   }  %>
	  </div>
	<%  } %>
    


    <!-- here we have to import the Date class. You will put the import in the first line of the jsp tag. Use the import attribute -->
    <p>The time is: <%= new Date() %></p>
</body>
</html>