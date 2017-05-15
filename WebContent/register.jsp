<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
function validateForm() {
    var username = document.forms["register"]["username"].value;
    var password = document.forms["register"]["password"].value;
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
<form name="register" action="RegisterController" method="post" onsubmit="return validateForm()">
<div class="jumbotron">
<center><div><input type="text" name="username" class="well" placeholder="Enter Username"/>
<br>
<input type="password" name="password" class="well" placeholder="Enter Password"/><br>
<input type="text" name="alias" class="well" placeholder="Enter Alias"/><br>
<input class="btn btn-danger" type="submit" value="Signup"/>
</div></center></div>
</form>
</body>
</html>