<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Car List</title>
</head>
<body>
<form action = "createNewCarListServlet" method="post">
List Name: <input type ="text" name = "carListName"><br />
Car Shopper Name: <input type = "text" name = "carShopperName"><br />

Available Items:<br />

<select name="allCarsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
   <option value = "${currentitem.id}">${currentitem.make} | ${currentitem.model} | ${currentitem.year}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add cars">
</form>
<a href = "index.html">Go add new cars instead.</a>
</body>
</html>