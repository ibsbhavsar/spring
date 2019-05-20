<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>Submitted Data</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<c:set var="id_count" value="0"></c:set>
	<div class="container">
		<h2>Below are the Submitted Data</h2>
		<table class="table">
			<thead>
				<tr>
					<th scope="row">#Id</th>
					<th scope="row">Title</th>
					<th scope="row">Category</th>
					<th scope="row">Update</th>
					<th scope="row">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${articleList}" var="article">
					<c:set var="id_count" value="${id_count+1}" />
					<tr class="warning">

						<td>${id_count}</td>
						<td>${article.title}</td>
						<td>${article.category}</td>
						<td><spring:url value="/crud/updateArticle/${article.id}"
								var="updateURL"></spring:url> <a href="${updateURL}"
							role="button">Update</a></td>
						<td><spring:url value="/crud/deleteArticle/${article.id}"
								var="deleteURL"></spring:url> <a href="${deleteURL}"
							role="button">Delete</a></td>
					</tr>
					<br>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/crud/addArticle/" var="addURL"></spring:url>
		<input type="button" onclick="location.href='${addURL}'"
			value="Add-Data">
	</div>
</body>
</html>