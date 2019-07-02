<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>We are adding some book's data here</title>
</head>
<body>
	<h2>ADD BOOK</h2>
	<spring:url value="/savebook" var="saveURL" />
	<form:form action="${saveURL}" modelAttribute="addBook" method="post">
		<form:hidden path="id" />
			Book Title <form:input path="title" />
		<br>
			Book Author<form:input path="author" />
		<br>
		<button type="submit" value="${addbook eq null ? 'ADD' : 'UPDATE'}"></button>
	</form:form>
</body>
</html>