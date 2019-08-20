<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/predefined/show-user.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Boot JSP Index</title>
</head>
<body>
<h1>Welcome ${username }!!!</h1>
<a href="${pathContext.request.contextPath }/Add-Todo">Add Todo</a><br>
<a href="${pathContext.request.contextPath }/Display-All-Todos">Display All Todos</a><br>
</body>
</html>