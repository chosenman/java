<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
 <head>
     <meta charset="utf-8">
<title>Ninja Gold</title>
 </head>
 <body>


      <h1>Welcome to Ninja Gold</h1>
      <div class="score">
        <form class="" action="/process_money" method="post">
          Your score:
          <span>
          	${score}
		</span>
          <input type="hidden" name="activity" value="reset">
          <input type="submit" class="butn" name="button" value="reset" />
        </form>

      </div>
      
      
    <div class="wrapper">
      <div class="boxes">
        <form class="box" action="/process_money" method="post">
          <h2>Farm</h2>
          <p>(earns 10-20 golds)</p>
          <input type="hidden" name="activity" value="farm"><br>
          <button type="submit" name="button">Find Gold</button>
        </form>

        <form class="box" action="/process_money" method="post">
          <h2>Cave</h2>
          <p>(earns 5-10 golds)</p>
          <input type="hidden" name="activity" value="cave"><br>
          <button type="submit" name="button">Find Gold</button>
        </form>

        <form class="box" action="/process_money" method="post">
          <h2>House</h2>
          <p>earns 2-5 golds</p>
          <input type="hidden" name="activity" value="house"><br>
          <button type="submit" name="button">Find Gold</button>
        </form>

        <form class="box" action="/process_money" method="post">
          <h2>Casino</h2>
          <p>(earns 0-50 golds)</p>
          <input type="hidden" name="activity" value="casino"><br>
          <button type="submit" name="button">Find Gold</button>
        </form>
      </div>
</div>
      
      <h2>Activities</h2>
      <div class="activities">
			<c:forEach var="row" items="${log}">
				<c:if test="${row.contains('lost')}">
				   <p style="color:red">${row}<p>
				</c:if>
				<c:if test="${!row.contains('lost')}">
				   <p style="color:green">${row}<p>
				</c:if>
			</c:forEach>
      </div>

 

    <style media="screen">
      .boxes { display:flex;
      width:100%; }
      .box button, .butn {
        padding:5px;
        margin:5px;
        background-color: #D84624;
        color:#fff;
        border:0;
        cursor:pointer;
      }
      .box {
        width:20%;
        margin:2%;
        border:1px solid black;
        text-align:center
      }
      .activities {
        padding:10px;
        height:200px;
        overflow-y: scroll;
        border:1px solid black;
      }
      .plus { color:green; }
      .minus { color:red; }

	.wrapper{ display:flex; }
	.container { width:23%; display:block; }
body { position: relative; }
img.ninjas { position: absolute; left: 50%; margin-left:-200px; }
.stuff { padding-top:320px; }
</style>
 </body>