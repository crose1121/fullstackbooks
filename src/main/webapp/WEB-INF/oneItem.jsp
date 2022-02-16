<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	<h1>Details: ${book.title}</h1>
	<p>Description: ${book.description}</p>
	<p>Language: ${book.language}</p>
	<p>Number of Pages: ${book.numberOfPages}</p>
</body>
</html>