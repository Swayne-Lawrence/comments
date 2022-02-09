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
	<div>
		<h1>Hello <c:out value="${user.name}"></c:out></h1>
		<a href="/homepage">home page</a>
		<a href="/logout">Logout</a>
	</div>
	
	<form:form action="/comment_form/${post.id}" method="post" modelAttribute="comment">
		<form:input path="user" type="hidden" value="${user.id }"/>
		<form:input path="id" type="hidden" value="${num}"/>
		<p>
			<form:label path="user_comment">Comment:</form:label>
			<form:textarea path="user_comment"/>
			<form:errors path="user_comment"></form:errors>
		</p>
		
		<button type="submit">Comment</button>
	</form:form>
</body>
</html>