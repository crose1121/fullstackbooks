<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Edit Book</title>
</head>
<body>
	<h1 style="text-align: center">Edit Book Here.</h1>
	<form:form action="/books/update/${book.id}" method="post" modelAttribute="book" style="width: 50%" class="container">
	<input type="hidden" name="_method" value="put"/>
	<div class="form-group">
	<p>
        <form:label path="title">Title</form:label>
        <form:errors path="title" class="text-danger"/>
        <form:input path="title" class="form-control"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description" class="text-danger"/>
        <form:textarea path="description" class="form-control"/>
    </p>
    <p>
        <form:label path="language">Language</form:label>
        <form:errors path="language" class="text-danger"/>
        <form:input path="language" class="form-control"/>
    </p>
    <p>
        <form:label path="numberOfPages">Pages</form:label>
        <form:errors path="numberOfPages" class="text-danger"/>     
        <form:input type="number" path="numberOfPages" class="form-control"/>
    </p>    
    <input type="submit" value="Submit" class="btn btn-success"/>    
	</div>
	<a href="/books" class="btn btn-warning">Home</a>
	<a href="/books/delete/${id}" class="btn btn-danger">Delete this book</a>
	</form:form> 
	<hr />
</body>
</html>