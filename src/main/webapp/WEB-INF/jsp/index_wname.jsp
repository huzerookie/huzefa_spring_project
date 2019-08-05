<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Boot JSP Index</title>
</head>
<body>

<font color="red">${message }</font>
<form method="POST">
Username:<input type="text" name="username"></input>
Password:<input type="password" name="password"></input>
<input type="submit" value="submit"/>
</form>

</body>
</html>