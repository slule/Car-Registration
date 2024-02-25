<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update car record</title>
</head>
<body>
	<form action="update" method="post">
	New Car Make: <input type="text" name="carMake" size="25" />
	New Car Model: <input type="text" name="carModel" size="25" />
	New Car Year: <input type="text" name="carYear" size="25" />
	
	Enter the Current Car Make: <input type="text" name=oldMake size="25"/>
	<input type="submit" value="update" />
	
	</form>

</body>
</html>