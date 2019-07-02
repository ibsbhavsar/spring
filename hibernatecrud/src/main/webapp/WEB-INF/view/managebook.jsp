<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Manage Books</h2>
	<c:set var="id_count" value="0"></c:set>
	<table>
		<tr>
			<th>ID</th>
			<th>TITLE</th>
			<th>AUTHOR</th>
		</tr>
		<c:forEach items="${booklist}" var="book">
			<c:set var="id_count" value="${id_count+1}" />
			<tr>
				<td>${id_count}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td><spring:url value="/updatebook/${book.id}"
						var="updateURL"/> <a href="${updateURL}">Update</a></td>
				<td><spring:url value="/deletebook/${book.id}"
						var="deleteURL" /> <a href="${deleteURL}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<spring:url value="/addbook/" var="addURL" />
	<input type="button" onclick="location.href='${addURL}'"
		value="Add-Data">
</body>
</html>