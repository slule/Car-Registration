<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Garage and cars</title>
</head>
<body>
	 List of all Garages and cars
	<table>	
		<c:forEach items="${requestScope.allGarage}" var="currentgarage">
			<tr>
				<td>${currentgarage.name} </td>
				<td>${currentgarage.location} </td>
			</tr>
			<c:forEach items="${currentgarage.cars}" var="currentcar">
				<tr>

					<td>${currentcar.carMake} </td>
					<td>${currentcar.carModel} </td>
					<td>${currentcar.carYear} </td>
				
				</tr>
			</c:forEach>
				
	
		</c:forEach>
	
	</table>
	

</body>
</html>

