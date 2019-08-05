<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div id="datepicker1"></div>
Date:<input type="text" id="datepicker">	


</form>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script type="text/javascript">
      $(function() {
        $("#datepicker1").datepicker({
          numberOfMonths:3
        }); 
      });
    </script>
</body>
</html>