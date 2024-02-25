<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Cars</title>
</head>
<body>


	
	List of Cars
	<table>
	
		<c:forEach items="${requestScope.carList}" var="currentCar">
			<tr>
				<td>${currentCar.carMake} </td>
				<td>${currentCar.carModel} </td>
				<td>${currentCar.carYear} </td>
				
			</tr>
		</c:forEach>
	
	</table>

</body>
</html>