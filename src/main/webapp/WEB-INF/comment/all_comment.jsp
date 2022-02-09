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
		<a href="/user_post/${post.id }">Back</a>
		<a href="/homepage">home page</a>
		<a href="/logout">Logout</a>
	</div>
	<h2> Comments for <c:out value="${post.title }"></c:out></h2>
	<table>
		<thead>
			<tr>
				<th> Comment</th>
				<th>User </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${post.comments }">
				<tr>
					<td><c:out value="${p.user_comment}"></c:out> </td>
					<td><strong><c:out value="${p.user.name }"></strong> </c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br> <a href="/create_comment/${post.id}">Add Comment</a>
</body>
</html>