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

Which form was pushed before: ${newTimer.getWhychButton()}
<c:if test="${newTimer.getWhychButton() == 'start' && startTime == 'empty'}">
   ${newTimer.setStartTime()}
   ${newTimer.cleanWhichButton()}
</c:if>
<c:if test="${newTimer.getWhychButton() == 'stop' && startTime != 'empty'}">
   ${newTimer.setStopTime()}
   ${newTimer.cleanWhichButton()}
</c:if>
<c:if test="${newTimer.getWhychButton() == 'reset' && startTime != 'empty'}">
   ${newTimer.setStopTime()}
   ${newTimer.setStartTime()}
   ${newTimer.cleanWhichButton()}
</c:if>

<br/>
Which form was pushed after: ${newTimer.getWhychButton()}
    <div >
    		<table style="width:100%;"><tr><td>
	        <form method="POST" action="/Stopwatch/Stopwatch">
	        <input type="hidden" name="action" value="start">
	        <button type="submit">Start</button>
	        </form>
    		</td><td style="text-align:center;">
	        <form method="POST" action="/Stopwatch/Stopwatch"> 
	        <input type="hidden" name="action" value="stop">
	        <button type="submit">Stop</button>
	        </form>
    		</td><td style="text-align:right">
	        <form method="POST" action="/Stopwatch/Stopwatch"> 
	        <input type="hidden" name="action" value="reset">
	        <button type="submit">Reset</button>
	        </form>
    		</td></tr></table>
 		
 		<table class="tbl"><tr><td>Start: ${newTimer.getstartTime()}</td><td>Current time ${newTimer.generateTimeNow()} </td><td> Running time: ${newTimer.totalTime()} </td></tr></table>
 		
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
			<c:forEach var="row" items="${newTimer.results}">
			   <tr>
			   <c:forEach var="col" items="${row}">
			   	<td>${col}</td>
			   	</c:forEach>
			   </tr>
			</c:forEach>
        			<%-- ${randomWord} --%>

        </table>

      generateTimeNow:  ${newTimer.generateTimeNow()} <br/>
      getResults:  ${newTimer.getResults()} <br/>
      getStopTime:  ${newTimer.getStopTime()} <br/>
      
    </div>
    
</body>
</html>