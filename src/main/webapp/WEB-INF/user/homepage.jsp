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
	<a href="/create_post">Create Post</a>
	<a href="/logout">Logout</a>
	</div>
	
	<h2>Community Posts</h2>
	<table>
		<thead>
			<tr>
				<th>Post</th>
				<th>|Made By|</th>
				<th>Actions </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${posts}">
				<c:choose>
					<c:when test="${user.id eq p.user.id }">
						<tr>
							<td><a href="/user_post/${p.user.id }"><c:out value="${p.title }"></c:out></a></td>
							<td> <p>Made By You</p></td>
							<td><a href="/all_comment/${p.id}">Comments</a> <form action="/delete/${p.id }" method="post"><button type="submit">Delete</button> </form> <a href="/edit_post/${p.id}">Edit</a></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td><a href="/user_post/${p.user.id }"><c:out value="${p.title }"></c:out></a></td>
							<td><c:out value="${p.user.name }"></c:out> </td>
							<td> <a href="/all_comment/${p.id}">Comments</a> </td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>