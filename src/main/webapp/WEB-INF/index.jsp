<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>First Full Stack Project!</title>
</head>
<body>
	<h1 style="text-align: center">Hello Full Stack Java! These are all the books to pick from.</h1>
	
	<table class="table table-dark container">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Title</th>
				<th scope="col">Description</th>
				<th scope="col">Language</th>
				<th scope="col">Number of Pages</th>
				<th scope="col">Actions: </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${allBooks}">
				<tr>
					<th scope="row">${book.id}</th>
					<td><a href="/books/${book.id}">${book.title}</a></td>
					<td>${book.description}</td>
					<td>${book.language}</td>
					<td>${book.numberOfPages}</td>
					<td>
					<a href="/books/edit/${book.id}">Edit</a> || 
					<a href="/books/delete/${book.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr />
	
	<h3 style="text-align: center">Add a book</h3>
	
	<form:form action="/books/create" method="post" modelAttribute="book" style="width: 50%" class="container">
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
    <input type="submit" value="Submit"/>    
	</div>
	</form:form> 
	

</body>
</html>