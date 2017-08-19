<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>

<div style="margin:0 auto; width:80%">

    <c:if test="${logoutMessage != null}">
    		<span style="color:green">
        <c:out value="${logoutMessage}"></c:out>
        </span>
    </c:if>

    <c:if test="${errorMessage != null}">
	    	<span style="color:red">
	        <c:out value="${errorMessage}"></c:out>
	    </span>
    </c:if>

<div style="float:right; width:48%">
    <h1>Login</h1>
    <form method="POST" action="/login">
        <p>
            <label for="username">Email</label>
            <input type="email" id="username" name="username"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login!"/>
    </form>
</div>

<div style="margin-right:50%">
    <h1>Register!</h1>
    
	<p><form:errors path="user.*"/></p> 
    
    <form:form method="POST" action="/registration" modelAttribute="user">
    
 
        <p>
            <form:label path="email" type="text">First Name:</form:label>
            <form:input path="email"/>
        </p>
    
        <p>
            <form:label path="userlastname">last name:</form:label>
            <form:input path="userlastname"/>
        </p>
    
        <p>
            <form:label path="username" >Email:</form:label>
            <form:input path="username"/>
        </p>
        
		<p>
            <form:label path="location" >Location:</form:label>
            <form:input path="location"/>
            
            <form:select path="state" width="20px" placeholder="state">
	<option value="AL">Alabama</option><option value="AK">Alaska</option><option value="AZ">Arizona</option>
	<option value="AR">Arkansas</option><option value="CA">California</option><option value="CO">Colorado</option>
	<option value="CT">Connecticut</option><option value="DE">Delaware</option><option value="DC">District Of Columbia</option>
	<option value="FL">Florida</option><option value="GA">Georgia</option><option value="HI">Hawaii</option>
	<option value="ID">Idaho</option><option value="IL">Illinois</option><option value="IN">Indiana</option>
	<option value="IA">Iowa</option><option value="KS">Kansas</option><option value="KY">Kentucky</option>
	<option value="LA">Louisiana</option><option value="ME">Maine</option><option value="MD">Maryland</option>
	<option value="MA">Massachusetts</option><option value="MI">Michigan</option><option value="MN">Minnesota</option>
	<option value="MS">Mississippi</option><option value="MO">Missouri</option><option value="MT">Montana</option>
	<option value="NE">Nebraska</option><option value="NV">Nevada</option><option value="NH">New Hampshire</option>
	<option value="NJ">New Jersey</option><option value="NM">New Mexico</option><option value="NY">New York</option>
	<option value="NC">North Carolina</option><option value="ND">North Dakota</option><option value="OH">Ohio</option>
	<option value="OK">Oklahoma</option><option value="OR">Oregon</option><option value="PA">Pennsylvania</option>
	<option value="RI">Rhode Island</option><option value="SC">South Carolina</option><option value="SD">South Dakota</option>
	<option value="TN">Tennessee</option><option value="TX">Texas</option><option value="UT">Utah</option><option value="VT">Vermont</option>
	<option value="VA">Virginia</option><option value="WA">Washington</option><option value="WV">West Virginia</option>
	<option value="WI">Wisconsin</option><option value="WY">Wyoming</option>
            </form:select>
		</p>
    

        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
</div>

</div>
</body>
</html>