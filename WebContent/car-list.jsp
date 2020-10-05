<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car List</title>
</head>
<body>
<form action="navigationServlet" method="post">
		<table>
			<c:forEach items="${requestScope.allCars}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>${currentitem.make}</td>
					<td>${currentitem.model}</td>
					<td>${currentitem.year}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToCar"> 
		<input type="submit" value="delete" name="doThisToCar"> 
		<input type="submit" value="add" name="doThisToCar">
	</form>
</body>
</html>