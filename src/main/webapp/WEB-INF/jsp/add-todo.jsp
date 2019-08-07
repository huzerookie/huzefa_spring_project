<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="/WEB-INF/predefined/date-calender.html" %>  
 <%@ include file="/WEB-INF/predefined/show-user.html" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="CSS/Master.css" rel="stylesheet" type="text/css" />
<title>Spring Boot JSP Index</title>

</head>
<body>
<form method="post">
Desc:<input type="textarea" name="desc"/><br>

<div id="holder"></div>
Date:<input type="text" id="datepicker1" name="datepicker">	<br>

<input type="submit" value="Submit"/>
</form>

</body>
</html>