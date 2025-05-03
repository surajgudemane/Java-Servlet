<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="UpdateServlet" method = post>
		Enter Showroom Name: <input type = text name=showRoom><br><br>
		Enter Showroom Location: <input type = text name=location><br><br>
		Updating Showroom Type: <input type = text name=type><br><br>
		<input type = submit value = Submit><input type = reset value = Reset>
	</form>

</body>
</html>