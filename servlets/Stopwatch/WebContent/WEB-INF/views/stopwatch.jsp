<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Stopwatch</title>
    <link href="/Stopwatch/style.css" media="all" rel="stylesheet" />
    
</head>
<body>

    <div >
    		<table style="width:100%;"><tr><td>
	        <form method="POST" action="/RandomWord/Random"><button type="submit">Start</button>
	        </form>
    		</td><td style="text-align:center;">
	        <form method="POST" action="/RandomWord/Random"> <button type="submit">Stop</button>
	        </form>
    		</td><td style="text-align:right">
	        <form method="POST" action="/RandomdomWord/Random"> <button type="submit">Reset</button>
	        </form>
    		</td></tr></table>
 		
 		<table class="tbl"><tr><td> </td><td>Current time ${currentTime} </td><td> </td></tr></table>
 		
        <table style="width:100%">
			<tr style="background:#ccc;">
				<td>
					Start
				</td><td>
					Stop
				</td><td>
					Total
				</td>
			</tr>
        			<%-- ${randomWord} --%>

        </table>

        ${date}
    </div>
    
</body>
</html>