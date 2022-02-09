<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Hello <c:out value="${user.name}"></c:out></h1>
		<a href="/homepage">home page</a>
		<a href="/logout">Logout</a>
	</div>
	
	<h2><c:out value="${post.title }"></c:out></h2>
	
	<textarea rows="10" cols="30" readonly style="resize:none;">
		<c:out value="${post.content}"></c:out>
	</textarea>
	
	<br><a href="/all_comment/${post.id}">View Comments</a>
</body>
</html>