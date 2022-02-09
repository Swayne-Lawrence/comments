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
	
	<h2> Create Post</h2>
	<form:form action="/post_form" method="post" modelAttribute="post">
		<form:input path="user" value="${user.id }" type="hidden"/>
		<p>
			<form:label path="title">Title</form:label>
			<form:input path="title"/>
			<form:errors path="title"></form:errors>
		</p>
		<p>
			<form:label path="content">Content</form:label>
			<form:textarea path="content"/>
			<form:errors path="content"></form:errors>
		</p>
		
		<button type="submit">Create</button>
	</form:form>
</body>
</html>