<%@page import="javax.websocket.MessageHandler.Whole"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
function validateForm() {
    var username = document.forms["login"]["username"].value;
    var password = document.forms["login"]["password"].value;
    if (username == "" || password == "") {
        alert("All details must be filled out");
        return false;
    }
    else if(password.length<8)
    	{
    	alert("Password must be greater then 8 chars");
    	return false;
    	}
}
</script>
<form name="login" action="LoginController" method="post" onsubmit="return validateForm()">
<div class="jumbotron">
<center><div><input type="text" name="username" class="well" placeholder="Enter Username"/>
<br>
<input type="password" name="password" class="well" placeholder="Enter Password"/><br>
<input class="btn btn-success" type="submit" value="Login"/>
</div></center></div>
</form>


</body>
</html>