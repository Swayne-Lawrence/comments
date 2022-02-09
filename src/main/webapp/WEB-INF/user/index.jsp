<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Create Account</h1>
	<div>
		<form:form action="/form" method="post" modelAttribute="user">
			<p>
				<form:label path="name">Name</form:label>
				<form:input path="name"/>
				<form:errors path="name"></form:errors> 
			</p>
			<p>
				<form:label path="email">Email</form:label>
				<form:input path="email" type="email"/>
				<form:errors path="email"></form:errors> 
			</p>
			<p>
				<form:label path="password">Password</form:label>
				<form:input path="password" type="password"/>
				<form:errors path="password"></form:errors> 
			</p>
			<p>
				<form:label path="confirmPw">Confirm Password</form:label>
				<form:input path="confirmPw" type="password"/>
				<form:errors path="confirmPw"></form:errors> 
			</p>
			<button type="submit">Create</button>
		</form:form>
	</div>
	<div>
		<h2>Login</h2>
		<form action="/login" method="post">
			<p>
    			<c:out value="${error}"/>
    		</p>
			<p>
				<label for="email">Email</label>
				<input type="email" name="email"/>
			</p>
			<p>
				<label for="password">Password</label>
				<input type="password" name="password"/>
			</p>
			<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>