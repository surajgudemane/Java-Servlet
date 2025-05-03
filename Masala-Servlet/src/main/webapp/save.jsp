<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="SaveServlet" method="post">
	
	<input type="text" placeholder="Enter Brand Name" name="brand"> <br><br>
	<input type="text" placeholder="Enter Masala Type" name="type"> <br><br>
	<input type="number" placeholder="Enter Quantity" name="quantity"> <br><br>
	<input type="number" placeholder="Enter Price" name="price"> <br><br>
	
	<button type="submit">Submit</button> &nbsp; <button type="reset">Reset</button>
	
	</form>
</body>
</html>