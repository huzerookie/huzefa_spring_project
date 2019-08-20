<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="/WEB-INF/predefined/date-calender.html" %>  
 <%@ include file="/WEB-INF/predefined/show-user.html" %>
 <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="s"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="CSS/Master.css" rel="stylesheet" type="text/css" />
<title>Spring Boot JSP Index</title>

</head>
<body>



<!-- s indicates spring commandBean -->
<s:form method="post" modelAttribute="todo">
<s:label path="desc">Desc:</s:label>
<s:input path="desc" type="text" name="desc" required="required"/><br><br>

<div id="message_print"></div>
<div id="holder"></div>
<s:label path="targetDate">Date:</s:label>
<s:input path="targetDate" type="text" id="datepicker1" name="datepicker" required="required"/>	<br>
<input type="submit" value="Submit"/>
</s:form>


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