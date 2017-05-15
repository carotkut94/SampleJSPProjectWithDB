<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selection of Choice</title>
</head>
<body>

<%

if(session.getAttribute("username")!=null)
{
response.sendRedirect("userhome.jsp");
}
else
{
	 %>
	<h1>User !logged in</h1>
	<%
}
%>

<center><div class="jumbotron" style="width: 300px; height: 400px">
	<h1>Welcome</H1>
	</br>
	</br>
	<input type="button" onclick="window.location('register.jsp')" name="Signup" class="btn btn-primary" value="Signup"/>
	<br></br>
	<input type="button" onclick="window.location('userlogin.jsp')" name="Login" class="btn btn-danger" value="Login"/>
</div></center>
</body>
</html>