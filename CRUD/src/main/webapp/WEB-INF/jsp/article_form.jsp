<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Article Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/crud/saveArticle" var="saveURL"></spring:url>
		<h2>Fill This Data.</h2>
		<form:form modelAttribute="articleForm" method="post"
			action="${saveURL}" cssClass="form">
			<form:hidden path="id" />
			<div class="container">

				<label>Title</label>


				<form:input path="title" required="required" />

			</div>
			<div class="container">

				<label>Category</label>


				<form:input path="category" required="required" />

			</div>

			<button type="submit">Save</button>
		</form:form>
	</div>
</body>
</html>