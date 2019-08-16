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
Desc:<input type="text" name="desc" required/><br><br>

<div id="message_print"></div>
<div id="holder"></div>
Date:<input type="text" id="datepicker1" name="datepicker" required>	<br>
<input type="submit" value="Submit"/>
</form>


<!-- <script>
function checkDate(userdate){
 //var userdate = document.getElementById("datepicker1").value;
 console.log(userdate);
 if(userdate > new Date()){
	 document.getElementById("message_print").innerHTML = "Kindly Enter Date After "+new Date();
	 return false;
 }
	return true;
}

</script> -->

</body>
</html>